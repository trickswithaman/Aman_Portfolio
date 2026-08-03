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
import myportfolio.composeapp.generated.resources.Notiq_Splash
import myportfolio.composeapp.generated.resources.All_Notes
import myportfolio.composeapp.generated.resources.Pinned_Note
import myportfolio.composeapp.generated.resources.Setting_screen
import myportfolio.composeapp.generated.resources.Change_light_theme
import myportfolio.composeapp.generated.resources.Create_And_edit_Notes
import myportfolio.composeapp.generated.resources.PF_All_Transaction
import myportfolio.composeapp.generated.resources.PF_Create_Goal
import myportfolio.composeapp.generated.resources.PF_Goal_Detail
import myportfolio.composeapp.generated.resources.PF_Splash
import myportfolio.composeapp.generated.resources.PF_add_transactionScreen
import myportfolio.composeapp.generated.resources.PF_dashboard
import myportfolio.composeapp.generated.resources.PF_insights
import myportfolio.composeapp.generated.resources.PF_transaction_Details

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
            projectName = "Proton Finance — Expense Tracker",
            projectDescription = "A native Android personal finance management tool built with modern practices to track expenses, set goals, and visualize spending habits.",
            skillTags = listOf("Kotlin", "Jetpack Compose", "MVVM", "Room", "Koin", "Data Visualization"),
            impPoints = listOf(
                "Built a high-performance native Android finance tracker using Jetpack Compose for a modern, reactive UI.",
                "Implemented interactive data visualizations and charts for spending analysis using custom Compose canvas.",
                "Integrated secure local storage with Room for managing sensitive financial transactions and goals."
            ),
            image = Res.drawable.PF_dashboard,
            imageBackgroundColor = Color(0xFFE3F2FD),
            isReversed = true,
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
            isShowOnMain = false
        ),
        ProjectData(
            projectName = "Notiq — Multiplatform Note App",
            projectDescription = "A modern note-taking application built with Compose Multiplatform, featuring persistent storage, pinning, and theme customization across Android and iOS.",
            skillTags = listOf("Kotlin", "Compose Multiplatform", "KMP", "SQLDelight", "Koin", "MVVM"),
            impPoints = listOf(
                "Engineered a cross-platform note-taking solution for Android and iOS with 100% shared UI and business logic.",
                "Implemented local persistence using SQLDelight for efficient, type-safe database operations.",
                "Designed a responsive UI with features like note pinning, search functionality, and dynamic theme switching."
            ),
            image = Res.drawable.Notiq_Splash,
            imageBackgroundColor = Color(0xFFF3E5F5),
            isReversed = true,
            isShowOnMain = true
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
            isShowOnMain = false
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
            projectName.contains("Proton") -> CaseStudyData(
                title = "Proton Finance\nExpense & Goal Tracker",
                description = "A comprehensive native Android personal finance management app built with Jetpack Compose, helping users track expenses, set financial goals, and gain insights into their spending habits.",
                tags = listOf("Android", "Jetpack Compose", "Room", "Koin", "MVVM", "Data Visualization"),
                heroImage = Res.drawable.PF_dashboard,
                heroBgColor = Color(0xFFE3F2FD),
                problem = "Managing personal finances can be overwhelming with multiple accounts and spending categories. Users often struggle to stay on top of their budgets and save for long-term goals. Proton Finance was created to provide a simple, intuitive, and unified platform to track every penny and plan for a secure financial future.",
                architectureItems = listOf(
                    "Jetpack Compose" to "Modern declarative UI for building a fast and fluid financial management experience.",
                    "Room Database" to "Local database for secure and fast access to financial records even without connectivity.",
                    "MVVM Architecture" to "Robust separation of concerns, ensuring business logic is independent of the UI.",
                    "Koin DI" to "Lightweight dependency injection for managing services and repositories efficiently."
                ),
                features = listOf(
                    "Expense Tracking" to "Easily log transactions with categories, dates, and descriptions.",
                    "Goal Management" to "Set financial milestones and track progress with visual indicators.",
                    "Spending Insights" to "Detailed charts and summaries to understand where your money goes.",
                    "Secure Offline" to "Complete privacy with all financial data staying on your device."
                ),
                mockups = listOf(
                    "Splash Screen" to Res.drawable.PF_Splash,
                    "Dashboard" to Res.drawable.PF_dashboard,
                    "Insights" to Res.drawable.PF_insights,
                    "All Transactions" to Res.drawable.PF_All_Transaction,
                    "Transaction Details" to Res.drawable.PF_transaction_Details,
                    "Add Transaction" to Res.drawable.PF_add_transactionScreen,
                    "Create Goal" to Res.drawable.PF_Create_Goal,
                    "Goal Detail" to Res.drawable.PF_Goal_Detail
                ),
                challenges = listOf(
                    "Data Visualization" to "Creating performant and responsive charts that handle large datasets smoothly on Android.",
                    "Local Security" to "Ensuring financial data is stored securely on the device with proper encryption."
                ),
                stats = listOf(
                    Triple("Fast", "Native Performance", "Highly responsive UI with smooth animations and transitions."),
                    Triple("Real-time", "Insights", "Instant feedback on spending habits and budget status."),
                    Triple("Secure", "Offline", "Complete privacy with all financial data staying on your device.")
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
            projectName.contains("Notiq") -> CaseStudyData(
                title = "Notiq\nMultiplatform Note App",
                description = "A modern, cross-platform note-taking application designed for simplicity and efficiency, built entirely with Kotlin Multiplatform and Compose Multiplatform.",
                tags = listOf("KMP", "Compose Multiplatform", "SQLDelight", "Koin", "MVVM"),
                heroImage = Res.drawable.All_Notes,
                heroBgColor = Color(0xFFF3E5F5),
                problem = "Users often need a simple yet powerful way to capture thoughts across different devices. Many note apps are either platform-locked or too complex. Notiq was built to provide a lightweight, consistent experience on both Android and iOS while maintaining a single codebase.",
                architectureItems = listOf(
                    "Compose Multiplatform" to "Shared UI components across Android and iOS, ensuring a consistent design language.",
                    "SQLDelight" to "Multiplatform database for type-safe local storage and offline capabilities.",
                    "MVVM Pattern" to "Clear separation of concerns with shared ViewModels for both platforms.",
                    "Koin DI" to "Dependency injection for managing shared components and platform-specific implementations."
                ),
                features = listOf(
                    "Note Management" to "Create, edit, and delete notes with a clean and intuitive interface.",
                    "Pinning" to "Keep important notes at the top for quick access.",
                    "Local Persistence" to "Works offline with all data stored securely on the device.",
                    "Theme Customization" to "Support for both light and dark modes with smooth transitions."
                ),
                mockups = listOf(
                    "Splash Screen" to Res.drawable.Notiq_Splash,
                    "All Notes" to Res.drawable.All_Notes,
                    "Pinned Note" to Res.drawable.Pinned_Note,
                    "Create & Edit" to Res.drawable.Create_And_edit_Notes,
                    "Settings" to Res.drawable.Setting_screen,
                    "Light Theme" to Res.drawable.Change_light_theme
                ),
                challenges = listOf(
                    "Shared Navigation" to "Implementing a unified navigation strategy that feels natural on both platforms.",
                    "Native Integration" to "Handling platform-specific APIs like status bar colors and safe area insets."
                ),
                stats = listOf(
                    Triple("100%", "Shared UI", "Used Compose Multiplatform to share the entire user interface across platforms."),
                    Triple("95%", "Code Sharing", "Shared almost all business logic and data layers using KMP."),
                    Triple("Offline", "Support", "Reliable performance even without an internet connection.")
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
