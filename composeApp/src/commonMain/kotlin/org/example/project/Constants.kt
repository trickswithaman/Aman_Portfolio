package org.example.project

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.ic_coding

object PortfolioConstants {
    // Basic Info
    const val NAME = "Shubham Gupta"
    const val EMAIL = "Shubhamgupta7536@gmail.com"
    const val PHONE_NUMBER = "917536018790"
    const val WHATSAPP_URL = "https://wa.me/$PHONE_NUMBER"
    const val GITHUB_URL = "https://github.com/Shubh7536"
    const val LINKEDIN_URL = "https://linkedin.com/in/shubhamgupta-1842981a1"
    const val MAIL_TO = "mailto:$EMAIL"
    const val COPYRIGHT_TEXT = "© 2024 Shubham Gupta. All rights reserved."

    // Career Timeline
    const val START_YEAR = 2018
    const val START_MONTH = 7

    // Hero Section
    val heroData = HeroData(
        headerText = buildAnnotatedString {
            append("Lead\n")
            withStyle(style = SpanStyle(color = PrimaryPurple)) {
                append("Android & KMP \nDeveloper")
            }
        },
        summary = "Accomplished Lead Android Developer with 7+ years of experience building 15+ production-grade mobile apps across fintech, SaaS, and enterprise domains.",
        totalProductionApps = 15,
        specialistCard = "Lead Android & KMP"
    )

    // About Me Section
    val aboutMeData = AboutMeData(
        leftText = "Leading teams and architecting scalable applications with modern Android development practices.",
        rightText = buildAnnotatedString {
            append("Lead Android Developer with ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = TextDark)) {
                append("7+ years of experience")
            }
            append(" building production-grade mobile apps across fintech, SaaS, and enterprise domains. Currently leading a team of 5+ developers at ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = TextDark)) {
                append("Lentra.AI")
            }
            append(".\n\nExpert in ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = TextDark)) {
                append("Kotlin, Jetpack Compose, Kotlin Multiplatform (KMP), and Clean Architecture")
            }
            append(". I have a proven track record of ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = TextDark)) {
                append("improving team velocity by 30% and reducing app crash rates by 35%")
            }
            append(" through proactive architecture decisions and performance optimization.")
        }
    )

    // Skills
    val skillsList = listOf(
        "Kotlin", "Jetpack Compose", "Kotlin Multiplatform (KMP)", "Java",
        "MVVM", "Clean Architecture", "Modularization", "Coroutines",
        "Hilt", "Koin", "Ktor", "Retrofit", "Room DB",
        "Firebase", "CI/CD", "Unit Testing", "Git", "Agile/Scrum"
    )

    // Experiences
    val experiences = listOf(
        ExperienceData(
            company = "Lentra.AI Pvt. Ltd.",
            role = "Lead Software Developer (Android)",
            period = "Oct 2023 - Present",
            points = listOf(
                "Led a team of 5+ Android developers, driving architecture decisions and raising team output by 30%.",
                "Architected and delivered the TVS Credit App, reducing loan approval time by 40% via CIBIL and BREx integration.",
                "Established Kotlin + Jetpack Compose MVVM/Clean Architecture with Hilt and implemented CI/CD pipelines.",
                "Reduced crash rate by 35% through proactive debugging with Android Profiler and Crashlytics."
            )
        ),
        ExperienceData(
            company = "InnovationM Technology Solutions",
            role = "Sr. Android Developer",
            period = "Jun 2022 - Oct 2023",
            points = listOf(
                "Developed GoNoGo, a dealer-facing finance platform, improving UI responsiveness and reducing bugs by 25%.",
                "Authored comprehensive technical documentation, reducing onboarding time for new team members.",
                "Redesigned key UI flows following Material Design guidelines, improving usability."
            )
        ),
        ExperienceData(
            company = "Tefe Information Technology",
            role = "Android Developer",
            period = "Dec 2019 - Jun 2022",
            points = listOf(
                "Led development of 15+ Android apps across project management, HR, real-time chat, and IoT domains.",
                "Implemented real-time features using Socket.io for instant messaging and live project tracking.",
                "Integrated HyperPay payment gateway and built geo-based attendance systems."
            )
        ),
        ExperienceData(
            company = "TPS Solution",
            role = "Jr. Android Developer",
            period = "Jul 2018 - Dec 2019",
            points = listOf(
                "Built 2 Android applications from scratch, including Palm Cuisine, a food ordering and tracking app.",
                "Gained end-to-end experience in app development, Play Store deployment, and client delivery."
            )
        )
    )

    // Projects (Main View)
    val projects = listOf(
        ProjectData(
            projectName = "TVS Credit App",
            projectDescription = "End-to-end digital loan platform for consumer durable and mobile loans, handling high-volume API integrations and serving thousands of customers.",
            skillTags = listOf("Kotlin", "Jetpack Compose", "MVVM", "Clean Architecture", "Hilt", "Coroutines"),
            impPoints = listOf(
                "Reduced loan approval time by 40% through CIBIL and BREx integration.",
                "Architected with modern MVVM/Clean Architecture and Hilt for dependency injection.",
                "Handled full journey from application to disbursement for thousands of customers."
            ),
            image = Res.drawable.ic_coding,
            imageBackgroundColor = Color(0xFFE5F1EF)
        ),
        ProjectData(
            projectName = "GoNoGo — Dealer Finance",
            projectDescription = "Dealer-facing finance platform for managing loan approvals, featuring real-time verification and streamlined dealer workflows.",
            skillTags = listOf("Kotlin", "Java", "Volley", "MVP", "IDFY", "Material Design"),
            impPoints = listOf(
                "Improved UI responsiveness and reduced reported bugs by 25%.",
                "Integrated IDFY for secure digital verification and identity management.",
                "Redesigned key UI flows to improve usability and reduce user friction."
            ),
            image = Res.drawable.ic_coding,
            imageBackgroundColor = Color(0xFFF0F4F8),
            isReversed = true
        ),
        ProjectData(
            projectName = "EYENAK — Project Management",
            projectDescription = "Comprehensive project management tool with real-time chat, calendar, task management, and secure payment integration.",
            skillTags = listOf("Kotlin", "Retrofit", "Room DB", "Socket.io", "HyperPay", "MVVM"),
            impPoints = listOf(
                "Implemented real-time chat and live project tracking using Socket.io.",
                "Integrated HyperPay payment gateway for secure in-app transactions.",
                "Built a robust geo-based attendance and HR management system."
            ),
            image = Res.drawable.ic_coding,
            imageBackgroundColor = Color(0xFFE8F5E9)
        )
    )

    // Case Studies (Detail View)
    fun getCaseStudy(projectName: String): CaseStudyData {
        return when {
            projectName.contains("TVS Credit") -> CaseStudyData(
                title = "TVS Credit\nDigital Loan App",
                description = "An end-to-end digital loan platform handling high-volume API integrations and serving thousands of customers.",
                tags = listOf("Kotlin", "Jetpack Compose", "MVVM", "Hilt", "Clean Architecture"),
                heroImage = Res.drawable.ic_coding,
                heroBgColor = Color(0xFFE5F1EF),
                problem = "The loan approval process was traditionally slow and manual, leading to customer drop-offs. TVS Credit needed a fast, automated digital solution to handle eligibility checks and disbursements in real-time.",
                architectureItems = listOf(
                    "Clean Architecture" to "Separated into layers for better maintainability and scaling of complex fintech logic.",
                    "MVVM Pattern" to "Ensuring a clean separation between UI and business logic.",
                    "Hilt DI" to "Standardized dependency injection for better testability and modularity.",
                    "CI/CD Pipelines" to "Automated build and release process to maintain high delivery velocity."
                ),
                features = listOf(
                    "CIBIL Integration" to "Real-time eligibility check via credit score integration.",
                    "BREx Rating" to "Automated business rule engine for instant loan decisions.",
                    "End-to-End Journey" to "Full loan lifecycle from application to disbursement.",
                    "High Performance" to "Optimized for high-volume API integrations and large user base."
                ),
                mockups = listOf(
                    "Loan Application" to Res.drawable.ic_coding,
                    "Eligibility Check" to Res.drawable.ic_coding,
                    "Disbursement Status" to Res.drawable.ic_coding
                ),
                challenges = listOf(
                    "Complex Integrations" to "Handling multiple third-party fintech APIs while maintaining app performance.",
                    "Data Security" to "Implementing strict security measures for sensitive financial data."
                ),
                stats = listOf(
                    Triple("40%", "Approval Speed", "Reduction in loan approval processing time."),
                    Triple("30%", "Team Velocity", "Improved through architecture standardization."),
                    Triple("100K+", "Users", "Serving a large scale of fintech customers.")
                )
            )
            projectName.contains("GoNoGo") -> CaseStudyData(
                title = "GoNoGo\nDealer Finance Platform",
                description = "A dealer-facing finance platform for managing loan approvals and dealer workflows.",
                tags = listOf("Kotlin", "Java", "MVP", "Volley", "IDFY"),
                heroImage = Res.drawable.ic_coding,
                heroBgColor = Color(0xFFF0F4F8),
                problem = "Dealers needed a streamlined way to submit loan applications and track approvals without navigating complex, fragmented systems.",
                architectureItems = listOf(
                    "MVP Pattern" to "Implemented for clear separation of concerns in the dealer-facing application.",
                    "Modular Design" to "Built with modular components for easier feature updates and testing.",
                    "IDFY Integration" to "Secure identity verification for both dealers and applicants.",
                    "Documentation" to "Comprehensive technical docs to reduce developer onboarding time."
                ),
                features = listOf(
                    "Loan Management" to "Centralized dashboard for dealers to manage all loan applications.",
                    "Real-time Verification" to "Instant identity and document verification via IDFY.",
                    "User Experience" to "Redesigned UI flows to reduce friction and improve usability.",
                    "Performance" to "Optimized networking and UI responsiveness for better dealer efficiency."
                ),
                mockups = listOf(
                    "Dealer Dashboard" to Res.drawable.ic_coding,
                    "Application Form" to Res.drawable.ic_coding,
                    "Approval Status" to Res.drawable.ic_coding
                ),
                challenges = listOf(
                    "Legacy Codebase" to "Maintaining and improving UI responsiveness within an existing MVP structure.",
                    "Onboarding Speed" to "Created detailed documentation to bring new developers up to speed quickly."
                ),
                stats = listOf(
                    Triple("25%", "Bug Reduction", "Achieved through UI redesign and code stabilization."),
                    Triple("Faster", "Onboarding", "Significantly reduced new member ramp-up time."),
                    Triple("Material", "Design", "Improved usability by following standard design guidelines.")
                )
            )
            else -> CaseStudyData( // EYENAK
                title = "EYENAK\nProject Management",
                description = "Comprehensive project management tool with real-time chat, calendar, task management, and secure payment integration.",
                tags = listOf("Kotlin", "Retrofit", "Room", "Socket.io", "HyperPay"),
                heroImage = Res.drawable.ic_coding,
                heroBgColor = Color(0xFFE8F5E9),
                problem = "Enterprises needed a unified tool that combines project management with real-time communication and HR features like geo-based attendance.",
                architectureItems = listOf(
                    "MVVM Pattern" to "Reactive architecture using Coroutines and LiveData for real-time updates.",
                    "Socket.io" to "Low-latency bidirectional communication for instant messaging.",
                    "Room DB" to "Offline-first capability for project data and attendance logs.",
                    "HyperPay" to "Secure payment gateway integration for in-app enterprise services."
                ),
                features = listOf(
                    "Real-time Chat" to "Instant messaging with file sharing and project-specific channels.",
                    "Geo-Attendance" to "Location-based attendance tracking for HR management.",
                    "Project Tracking" to "Live status updates and task management for enterprise teams.",
                    "Payment Integration" to "Secure in-app transactions for premium features and services."
                ),
                mockups = listOf(
                    "Chat Interface" to Res.drawable.ic_coding,
                    "Project Board" to Res.drawable.ic_coding,
                    "Attendance Log" to Res.drawable.ic_coding
                ),
                challenges = listOf(
                    "High Concurrency" to "Managing real-time chat and tracking for thousands of concurrent users.",
                    "Multi-Domain" to "Balancing features across Project Management, HR, and IoT domains."
                ),
                stats = listOf(
                    Triple("15+", "Apps Live", "Successfully delivered multiple production apps on Play Store."),
                    Triple("Real-time", "Efficiency", "Improved team communication through integrated chat."),
                    Triple("Geo-based", "Accuracy", "Reliable attendance tracking for remote and on-site teams.")
                )
            )
        }
    }
}
