package org.example.project.components

// jsMain
import kotlinx.browser.document
import org.w3c.dom.HTMLAnchorElement

actual fun downloadResume() {
    val link = document.createElement("a") as HTMLAnchorElement
    link.href = RESUME_URL
    link.download = "Aman_Saxena_Resume.pdf"
    document.body?.appendChild(link)
    link.click()
    document.body?.removeChild(link)
}