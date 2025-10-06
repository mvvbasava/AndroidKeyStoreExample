package com.example.androidkeystoreexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 *
 * Android Key Store
 *
 * 🔑 What is Android Keystore used for?
 *
 * The Android Keystore system is used to
 * 1. securely generate,
 * 2. securely store, and
 * 3. securely use cryptographic keys
 *
 * inside a hardware-backed or software-backed container.
 *
 * Main benefits:
 * 1. Keys never leave the secure hardware (Trusted Execution Environment / TEE or StrongBox).
 * 2. You can use these keys for encryption / decryption, signing, and authentication.
 * 3. Improves app security since raw keys are never exposed to the app’s process or filesystem.
 * 4. Commonly used for storing tokens, passwords, PINs, biometric authentication, and digital signatures.
 *
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val TAG = "KeystoreDemo"
        super.onCreate(savedInstanceState)

        KeystoreManager.generateSecretKey()
        val secretKey = KeystoreManager.getSecretKey()
        Log.d(TAG, "secretKey: $secretKey")

        val mySensitivePasswordToBeEncrypted = "MySensitivePassword123"
        Log.d(TAG, "mySensitivePasswordToBeEncrypted: $mySensitivePasswordToBeEncrypted")
        val (encrypted, iv) = CryptoManager.encrypt(mySensitivePasswordToBeEncrypted, secretKey)
        Log.d(TAG, "Encrypted: $encrypted")

        val decrypted = CryptoManager.decrypt(encrypted, iv, secretKey)
        Log.d(TAG, "Decrypted: $decrypted")
    }
}




