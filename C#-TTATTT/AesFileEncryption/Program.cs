using System.Security.Cryptography;

namespace AesFileEncryption
{
    class Program
    {
        static void Main(string[] args)
        {
            string inputFile = "input.txt";
            string encryptedFile = "encrypted.bin";
            string decryptedFile = "decrypted.txt";
            string password = "bestPassword";

            EncryptFile(inputFile, encryptedFile, password);

            DecryptFile(encryptedFile, decryptedFile, password);
        }

        static void EncryptFile(string inputFile, string outputFile, string password)
        {
            byte[] salt = GenerateRandomSalt();
            using (Aes aes = Aes.Create())
            {
                Rfc2898DeriveBytes keyGenerator = new Rfc2898DeriveBytes(password, salt);
                aes.Key = keyGenerator.GetBytes(aes.KeySize / 8);
                aes.IV = keyGenerator.GetBytes(aes.BlockSize / 8);
                aes.Mode = CipherMode.CBC;

                using (FileStream outputStream = new FileStream(outputFile, FileMode.Create))
                {
                    outputStream.Write(salt, 0, salt.Length);
                    using (CryptoStream cryptoStream = new CryptoStream(outputStream, aes.CreateEncryptor(), CryptoStreamMode.Write))
                    {
                        using (FileStream inputStream = new FileStream(inputFile, FileMode.Open))
                        {
                            inputStream.CopyTo(cryptoStream);
                            cryptoStream.FlushFinalBlock();
                        }
                    }
                }
            }
        }

        static void DecryptFile(string inputFile, string outputFile, string password)
        {
            using (FileStream inputStream = new FileStream(inputFile, FileMode.Open))
            {
                byte[] salt = new byte[16];
                inputStream.Read(salt, 0, salt.Length);
                using (Aes aes = Aes.Create())
                {
                    Rfc2898DeriveBytes keyGenerator = new Rfc2898DeriveBytes(password, salt);
                    aes.Key = keyGenerator.GetBytes(aes.KeySize / 8);
                    aes.IV = keyGenerator.GetBytes(aes.BlockSize / 8);
                    aes.Mode = CipherMode.CBC;

                    using (CryptoStream cryptoStream = new CryptoStream(inputStream, aes.CreateDecryptor(), CryptoStreamMode.Read))
                    {
                        using (FileStream outputStream = new FileStream(outputFile, FileMode.Create))
                        {
                            cryptoStream.CopyTo(outputStream);
                        }
                    }
                }
            }
        }

        static byte[] GenerateRandomSalt()
        {
            byte[] salt = new byte[16];
            using (var rng = RandomNumberGenerator.Create())
            {
                rng.GetBytes(salt);
            }
            return salt;
        }
    }
}