using System.Security.Cryptography;
using System.Text;

namespace RsaEncryption
{
    class Program
    {
        static void Main(string[] args)
        {
            try
            {
                string plaintext = "Xin chao cac ban CT06N!";

                byte[] dataToEncrypt = UnicodeEncoding.UTF8.GetBytes(plaintext);
                byte[]? encryptedData;
                byte[]? decryptedData;

                // Create a new instance of RSACryptoServiceProvider to generate 
                // public and private key data.
                using (RSACryptoServiceProvider RSA = new RSACryptoServiceProvider())
                {
                    // Use public key to encrypt data
                    // and a boolean flag specifying no OAEP padding.
                    encryptedData = RSAEncrypt(dataToEncrypt, RSA.ExportParameters(false), false);
                    Console.WriteLine("Encrypted plaintext: {0}",
                       Convert.ToBase64String(encryptedData));

                    // Use private key to decrypt data
                    // and a boolean flag specifying no OAEP padding.
                    decryptedData = RSADecrypt(encryptedData, RSA.ExportParameters(true), false);
                    Console.WriteLine("Decrypted plaintext: {0}",
                        UnicodeEncoding.UTF8.GetString(decryptedData));
                }
            }
            catch (ArgumentNullException e)
            {
                Console.WriteLine(e.Message);
                Console.WriteLine("Encryption failed.");
            }
        }

        public static byte[]? RSAEncrypt(byte[] DataToEncrypt, RSAParameters RSAKeyInfo,
            bool DoOAEPPadding)
        {
            try
            {
                byte[] encryptedData;
                using (RSACryptoServiceProvider RSA = new RSACryptoServiceProvider())
                {
                    // Import the RSA Key information. This only needs to include 
                    // the public key information.
                    RSA.ImportParameters(RSAKeyInfo);
                    encryptedData = RSA.Encrypt(DataToEncrypt, DoOAEPPadding);
                }
                return encryptedData;
            }
            catch (CryptographicException e)
            {
                Console.WriteLine(e.Message);
                return null;
            }
        }

        public static byte[]? RSADecrypt(byte[] DataToDecrypt, RSAParameters RSAKeyInfo,
            bool DoOAEPPadding)
        {
            try
            {
                byte[] decryptedData;
                using (RSACryptoServiceProvider RSA = new RSACryptoServiceProvider())
                {
                    // Import the RSA Key information. This needs to include the 
                    // private key information.
                    RSA.ImportParameters(RSAKeyInfo);
                    decryptedData = RSA.Decrypt(DataToDecrypt, DoOAEPPadding);
                }
                return decryptedData;
            }
            catch (CryptographicException e)
            {
                Console.WriteLine(e.ToString());
                return null;
            }
        }
    }
}