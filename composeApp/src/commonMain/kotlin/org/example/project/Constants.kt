package org.example.project

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.gym_login
import myportfolio.composeapp.generated.resources.ic_coding
import myportfolio.composeapp.generated.resources.gym_otp
import myportfolio.composeapp.generated.resources.gym_register_members
import myportfolio.composeapp.generated.resources.gum_select_package
import myportfolio.composeapp.generated.resources.gym_coach_list
import myportfolio.composeapp.generated.resources.gym_member_list
import myportfolio.composeapp.generated.resources.ic_ld_dashboard
import myportfolio.composeapp.generated.resources.ic_ld_dsa_dashboard
import myportfolio.composeapp.generated.resources.ic_ld_dsa_e_kyc
import myportfolio.composeapp.generated.resources.ic_ld_dsa_lead_status
import myportfolio.composeapp.generated.resources.ic_ld_dsa_login_screen
import myportfolio.composeapp.generated.resources.ic_ld_dsa_payout_history
import myportfolio.composeapp.generated.resources.ic_ld_dsa_profile_and_menu
import myportfolio.composeapp.generated.resources.ic_ld_login
import myportfolio.composeapp.generated.resources.ic_ld_onboarding
import myportfolio.composeapp.generated.resources.ic_ld_profile
import myportfolio.composeapp.generated.resources.ic_ld_transfer_funds
import myportfolio.composeapp.generated.resources.ic_ld_welcome
import myportfolio.composeapp.generated.resources.ic_loan_digit_dsa_onboarding
import myportfolio.composeapp.generated.resources.ic_payment_success

object PortfolioConstants {
    // Basic Info
    const val NAME = "Aman Saxena"
    const val EMAIL = "trickswithaman183@gmail.com"
    const val PHONE_NUMBER = "918272890216"
    const val WHATSAPP_URL = "https://wa.me/$PHONE_NUMBER"
    const val GITHUB_URL = "https://github.com/trickswithaman"
    const val LINKEDIN_URL = "https://linkedin.com/in/aman-saxena-15a515329"
    const val MAIL_TO = "mailto:$EMAIL"
    const val COPYRIGHT_TEXT = "© 2026 Portfolio. Designed for the Future."

    // Career Timeline
    const val START_YEAR = 2024
    const val START_MONTH = 11

    // Hero Section
    val heroData = HeroData(
        headerText = buildAnnotatedString {
            append("Native\n")
            withStyle(style = SpanStyle(color = PrimaryPurple)) {
                append("Android & KMP \nDeveloper")
            }
        },
        summary = "Android Developer and KMP Specialist building scalable, high-quality apps for Fintech & SaaS, specializing in sharing business logic across Android, iOS, and Web.",
        totalProductionApps = 4,
        specialistCard = "Native & KMP"
    )

    // About Me Section
    val aboutMeData = AboutMeData(
        leftText = "Building scalable applications with modern Android development practices and clean architecture.",
        rightText = buildAnnotatedString {
            append("Android Developer with 1.5+ years of experience building scalable and maintainable applications using ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = TextDark)) {
                append("Kotlin, Jetpack Compose, and Kotlin Multiplatform")
            }
            append(". I focus on writing clean, modular code and designing applications that are easy to scale and maintain.\n\n")
            append("My approach is centered around performance, code quality, and delivering reliable user experiences. I continuously explore modern Android development practices and aim to build applications that follow industry standards.")
        }
    )

    // Skills
    val skillsList = listOf(
        "Kotlin", "Jetpack Compose", "Kotlin Multiplatform (KMP)", "MVVM",
        "Clean Architecture", "Kotlin Coroutines", "State Management",
        "REST API Integration", "Retrofit", "Ktor", "Firebase",
        "Room Database", "Git & GitHub", "Postman", "Debugging"
    )

    // Experiences
    val experiences = listOf(
        ExperienceData(
            company = "Solvonix Technologies",
            role = "Android Developer",
            period = "Dec 2024 - Present",
            points = listOf(
                "Designed and delivered features across 4+ live Android and cross-platform apps, including fintech products with 100K+ active users.",
                "Architected and implemented shared KMP modules targeting Android, iOS, and Web — reducing duplicate business logic by ~60%.",
                "Reduced app crash rate by ~35% via systematic crash analysis with Firebase Crashlytics and lifecycle optimization.",
                "Integrated 20+ REST APIs using Retrofit and Ktor, leveraging Kotlin Coroutines and Flow for non-blocking operations."
            )
        )
    )

    // Projects (Main View)
    val projects = listOf(
        ProjectData(
            projectName = "Musklr — Gym Management System",
            projectDescription = "A cross-platform SaaS solution built with Kotlin Multiplatform to streamline gym operations, member engagement, and staff management across Android, iOS, and Web.",
            skillTags = listOf("Kotlin", "Jetpack Compose", "KMP", "Koin", "MVI", "Ktor", "Firebase"),
            impPoints = listOf(
                "Delivered a single shared codebase across Android, iOS, and Web, eliminating ~60% of platform-specific code duplication.",
                "Architected MVI pattern with Koin dependency injection for a fully testable and maintainable codebase.",
                "Built core features: real-time attendance tracking and subscription lifecycle management."
            ),
            image = Res.drawable.gym_login,
            imageBackgroundColor = Color(0xFFE5F1EF),
            isShowOnMain = true
        ),
        ProjectData(
            projectName = "LoanDigit — Personal Loan App",
            projectDescription = "Live fintech app serving 100,000+ users, featuring e-KYC onboarding, EMI tracking, and RBI-compliant transparency.",
            skillTags = listOf("Kotlin", "Jetpack Compose", "MVVM", "Retrofit", "Firebase", "Fintech"),
            impPoints = listOf(
                "Implemented e-KYC onboarding flow and EMI repayment tracking screens for 100K+ active users.",
                "Delivered Retrofit-based REST API integrations for lender assessment and credit scoring.",
                "Built RBI-compliant UI screens with full APR disclosures and processing fee transparency."
            ),
            image = Res.drawable.ic_ld_onboarding,
            imageBackgroundColor = Color(0xFFF0F4F8),
            isReversed = true,
            isShowOnMain = true
        ),
        ProjectData(
            projectName = "ddd",
            projectDescription = "Live fintech app serving 100,000+ users, featuring e-KYC onboarding, EMI tracking, and RBI-compliant transparency.",
            skillTags = listOf("Kotlin", "Jetpack Compose", "MVVM", "Retrofit", "Firebase", "Fintech"),
            impPoints = listOf(
                "Implemented e-KYC onboarding flow and EMI repayment tracking screens for 100K+ active users.",
                "Delivered Retrofit-based REST API integrations for lender assessment and credit scoring.",
                "Built RBI-compliant UI screens with full APR disclosures and processing fee transparency."
            ),
            image = Res.drawable.ic_ld_onboarding,
            imageBackgroundColor = Color(0xFFF0F4F8),
            isReversed = true,
            isShowOnMain = false
        ),
        ProjectData(
            projectName = "LoanDigit Partner — Agent / DSA App",
            projectDescription = "A lead management pipeline for financial agents, featuring credit checks, commission payouts, and role-specific onboarding.",
            skillTags = listOf("Kotlin", "Jetpack Compose", "MVVM", "Retrofit", "Firebase"),
            impPoints = listOf(
                "Implemented lead management pipeline (onboarding → credit check → approval → disbursement) with state-driven UI.",
                "Delivered real-time commission payout and instant bank transfer features using secure backend APIs.",
                "Built role-specific onboarding flows supporting multi-type agent registration."
            ),
            image = Res.drawable.ic_loan_digit_dsa_onboarding,
            imageBackgroundColor = Color(0xFFE8F5E9),
            isShowOnMain = true
        )
    )

    // Case Studies (Detail View)
    fun getCaseStudy(projectName: String): CaseStudyData {
        return when {
            projectName.contains("Musklr") -> CaseStudyData(
                title = "Musklr Gym\nManagement System",
                description = "A cross-platform SaaS solution built with Kotlin Multiplatform to streamline gym operations, member engagement, and staff management across Android, iOS, and Web.",
                tags = listOf("KMP", "Compose Multiplatform", "Firebase", "MVI", "Ktor", "Koin"),
                heroImage = Res.drawable.gym_login,
                heroBgColor = Color(0xFFE5F1EF),
                problem = "Traditional gym management systems are often fragmented, relying on separate tools for member tracking, billing, and scheduling. This creates data silos and operational friction. Gym owners needed a unified ecosystem that provides a seamless experience for both staff on desktops and members on mobile devices, while minimizing development costs for multiple platforms.",
                architectureItems = listOf(
                    "Clean Architecture" to "Structured into Core, Data, Domain, and Presentation layers for maximum decoupling and scalability.",
                    "MVI Pattern" to "Predictable state management using Model-View-Intent with a shared BaseViewModel across KMP.",
                    "Use Case Driven" to "Domain logic encapsulated in specialized UseCases, making the business layer testable and modular.",
                    "Koin DI & Ktor" to "Lightweight dependency injection and modern asynchronous networking for a seamless multiplatform experience."
                ),
                features = listOf(
                    "Attendance Tracking" to "QR based check-in and real-time attendance dashboards for managers.",
                    "Subscriptions" to "Automated billing, renewal reminders, and multiple membership tier support.",
                    "Role Based Access" to "Different UI and permissions for Owners, Staff, and Members.",
                    "Cross-Platform" to "Seamless experience across Android, iOS, and Web with 100% shared logic."
                ),
                mockups = listOf(
                    "Sign In Screen" to Res.drawable.gym_login,
                    "OTP Verification" to Res.drawable.gym_otp,
                    "Member Registration" to Res.drawable.gym_register_members,
                    "Plan Selection" to Res.drawable.gum_select_package,
                    "Coach Directory" to Res.drawable.gym_coach_list,
                    "Member Directory" to Res.drawable.gym_member_list
                ),
                challenges = listOf(
                    "Platform-Specific UI" to "Ensuring a cohesive brand experience while respecting the UX paradigms of both Android and iOS.",
                    "Design System Tokens" to "Implemented a shared design system with shared colors and typography, but platform-specific navigation."
                ),
                stats = listOf(
                    Triple("70%", "Shared Codebase", "Across 3 platforms, significantly reducing development and bug fixing."),
                    Triple("40%", "Development Speed", "Improved time-to-market for new features using shared business logic."),
                    Triple("MVI", "Maintainability", "Simplified debugging through a unidirectional data flow and clear state.")
                )
            )
            projectName.contains("LoanDigit") && !projectName.contains("Partner") -> CaseStudyData(
                title = "LoanDigit\nPersonal Loan App",
                description = "A live fintech application serving over 100,000 users, providing a seamless digital lending experience with automated onboarding and real-time tracking.",
                tags = listOf("Android", "Compose", "MVVM", "Retrofit", "Firebase", "Fintech"),
                heroImage = Res.drawable.ic_coding,
                heroBgColor = Color(0xFFF0F4F8),
                problem = "The digital lending space requires high trust and transparency. Users often find loan applications complex and opaque. LoanDigit needed a solution that simplifies the e-KYC process and provides clear, RBI-compliant disclosures while handling high traffic volume.",
                architectureItems = listOf(
                    "MVVM Pattern" to "Separation of UI and business logic for better testability and maintainability.",
                    "Retrofit API" to "Robust network layer with custom error handling for complex financial transactions.",
                    "Firebase Auth" to "Secure and seamless phone-based authentication for user onboarding.",
                    "Clean UI State" to "Reactive UI updates based on backend processing status for real-time feedback."
                ),
                features = listOf(
                    "e-KYC Onboarding" to "Streamlined digital verification process for instant loan eligibility.",
                    "EMI Tracking" to "Comprehensive dashboard for users to track repayments and schedules.",
                    "APR Transparency" to "Clear breakdown of fees and interest rates as per regulatory guidelines.",
                    "Real-time Updates" to "Push notifications and status tracking for disbursement and approvals."
                ),
                mockups = listOf(
                    "Onboarding Flow" to Res.drawable.ic_ld_onboarding,
                    "Login Screen" to Res.drawable.ic_ld_login,
                    "Welcome Screen" to Res.drawable.ic_ld_welcome,
                    "Dashboard Screen" to Res.drawable.ic_ld_dashboard,
                    "Transfer Fund Screen" to Res.drawable.ic_ld_transfer_funds,
                    "Payment Success Screen" to Res.drawable.ic_payment_success,
                    "Profile Screen" to Res.drawable.ic_ld_profile,

                ),
                challenges = listOf(
                    "High User Load" to "Optimizing performance to handle 100K+ active users without latency issues.",
                    "Regulatory Compliance" to "Implementing strict RBI digital lending guidelines for data privacy and transparency."
                ),
                stats = listOf(
                    Triple("100K+", "Downloads", "Achieved a significant milestone on the Google Play Store."),
                    Triple("35%", "Crash Reduction", "Optimized app stability via systematic Firebase Crashlytics analysis."),
                    Triple("3.8 ★", "User Rating", "Maintained a strong user satisfaction score in the competitive fintech space.")
                )
            )
            projectName.contains("ddd") && !projectName.contains("Partner") -> CaseStudyData(
                title = "LoanDigit\nPersonal Loan App",
                description = "A live fintech application serving over 100,000 users, providing a seamless digital lending experience with automated onboarding and real-time tracking.",
                tags = listOf("Android", "Compose", "MVVM", "Retrofit", "Firebase", "Fintech"),
                heroImage = Res.drawable.ic_coding,
                heroBgColor = Color(0xFFF0F4F8),
                problem = "The digital lending space requires high trust and transparency. Users often find loan applications complex and opaque. LoanDigit needed a solution that simplifies the e-KYC process and provides clear, RBI-compliant disclosures while handling high traffic volume.",
                architectureItems = listOf(
                    "MVVM Pattern" to "Separation of UI and business logic for better testability and maintainability.",
                    "Retrofit API" to "Robust network layer with custom error handling for complex financial transactions.",
                    "Firebase Auth" to "Secure and seamless phone-based authentication for user onboarding.",
                    "Clean UI State" to "Reactive UI updates based on backend processing status for real-time feedback."
                ),
                features = listOf(
                    "e-KYC Onboarding" to "Streamlined digital verification process for instant loan eligibility.",
                    "EMI Tracking" to "Comprehensive dashboard for users to track repayments and schedules.",
                    "APR Transparency" to "Clear breakdown of fees and interest rates as per regulatory guidelines.",
                    "Real-time Updates" to "Push notifications and status tracking for disbursement and approvals."
                ),
                mockups = listOf(
                    "Onboarding Flow" to Res.drawable.ic_ld_onboarding,
                    "Login Screen" to Res.drawable.ic_ld_login,
                    "Welcome Screen" to Res.drawable.ic_ld_welcome,
                    "Dashboard Screen" to Res.drawable.ic_ld_dashboard,
                    "Transfer Fund Screen" to Res.drawable.ic_ld_transfer_funds,
                    "Payment Success Screen" to Res.drawable.ic_payment_success,
                    "Profile Screen" to Res.drawable.ic_ld_profile,

                    ),
                challenges = listOf(
                    "High User Load" to "Optimizing performance to handle 100K+ active users without latency issues.",
                    "Regulatory Compliance" to "Implementing strict RBI digital lending guidelines for data privacy and transparency."
                ),
                stats = listOf(
                    Triple("100K+", "Downloads", "Achieved a significant milestone on the Google Play Store."),
                    Triple("35%", "Crash Reduction", "Optimized app stability via systematic Firebase Crashlytics analysis."),
                    Triple("3.8 ★", "User Rating", "Maintained a strong user satisfaction score in the competitive fintech space.")
                )
            )
            else -> CaseStudyData( // LoanDigit Partner
                title = "LoanDigit Partner\nAgent / DSA App",
                description = "A dedicated platform for Direct Selling Agents (DSAs) and financial partners to manage leads, track commissions, and facilitate loan disbursements.",
                tags = listOf("Android", "Jetpack Compose", "MVVM", "Retrofit", "Firebase"),
                heroImage = Res.drawable.ic_loan_digit_dsa_onboarding,
                heroBgColor = Color(0xFFE8F5E9),
                problem = "Financial agents lacked a centralized tool to manage their lead pipelines and track their earnings. Managing multiple customer applications manually led to inefficiencies and delayed disbursements.",
                architectureItems = listOf(
                    "State-driven UI" to "Using Compose state management to handle complex multi-step onboarding flows.",
                    "Secure API Layer" to "Implementing encrypted communication for sensitive financial and identity data.",
                    "Role-based Logic" to "Dynamic UI adjustments based on agent types (DSA, Insurance, Advisor).",
                    "Firebase Integration" to "Real-time sync of lead statuses and commission updates."
                ),
                features = listOf(
                    "Lead Pipeline" to "End-to-end tracking from customer onboarding to disbursement.",
                    "Commission Payouts" to "Instant bank transfer features and real-time earnings dashboard.",
                    "Agent Verification" to "Automated profile verification and multi-type registration support.",
                    "Document Manager" to "Secure upload and management of customer identity and financial documents."
                ),
                mockups = listOf(
                    "Onboarding Screen" to Res.drawable.ic_loan_digit_dsa_onboarding,
                    "Login Screen" to Res.drawable.ic_ld_dsa_login_screen,
                    "Dashboard Screen" to Res.drawable.ic_ld_dsa_dashboard,
                    "Payout Screen" to Res.drawable.ic_ld_dsa_payout_history,
                    "Lead Status Screen" to Res.drawable.ic_ld_dsa_lead_status,
                    "Menu And Profile Screen" to Res.drawable.ic_ld_dsa_profile_and_menu,
                    "E-KYC Screen" to Res.drawable.ic_ld_dsa_e_kyc,
                ),
                challenges = listOf(
                    "Complex State Flow" to "Managing the intricate states of loan applications across multiple parties.",
                    "Security & Privacy" to "Ensuring highest level of security for customer lead data and agent credentials."
                ),
                stats = listOf(
                    Triple("60%", "Efficiency", "Increased agent productivity by automating manual lead tracking."),
                    Triple("Instant", "Payouts", "Enabled real-time commission settlements for verified partners."),
                    Triple("Scalable", "Architecture", "Built to support thousands of agents across different financial tiers.")
                )
            )
        }
    }
}
