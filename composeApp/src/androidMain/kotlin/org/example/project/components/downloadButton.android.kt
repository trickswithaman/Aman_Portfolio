package org.example.project.components

// androidMain
import android.content.Intent
import android.net.Uri
import androidx.core.content.FileProvider
import android.content.Context
import java.io.File
import java.io.FileOutputStream

lateinit var appContext: Context

actual fun downloadResume() {
    val file = File(appContext.cacheDir, "resume.pdf")

    if (!file.exists()) {
        val input = appContext.resources.openRawResource(RESUME_URL.toInt())
        val output = FileOutputStream(file)
        input.copyTo(output)
        input.close()
        output.close()
    }

    val uri: Uri = FileProvider.getUriForFile(
        appContext,
        "${appContext.packageName}.provider",
        file
    )

    val intent = Intent(Intent.ACTION_VIEW).apply {
        setDataAndType(uri, "application/pdf")
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    }

    appContext.startActivity(intent)
}