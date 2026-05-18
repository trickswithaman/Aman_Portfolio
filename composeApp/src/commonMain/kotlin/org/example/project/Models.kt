package org.example.project

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import org.jetbrains.compose.resources.DrawableResource

data class ExperienceData(
    val company: String,
    val role: String,
    val period: String,
    val points: List<String>
)

data class ProjectData(
    val projectName: String,
    val projectDescription: String,
    val skillTags: List<String>,
    val impPoints: List<String>,
    val image: DrawableResource,
    val imageBackgroundColor: Color = Color.White,
    val isReversed: Boolean = false,
)

data class CaseStudyData(
    val title: String,
    val description: String,
    val tags: List<String>,
    val heroImage: DrawableResource,
    val heroBgColor: Color,
    val problem: String,
    val architectureItems: List<Pair<String, String>>,
    val features: List<Pair<String, String>>,
    val mockups: List<Pair<String, DrawableResource>>,
    val challenges: List<Pair<String, String>>, // Challenge, Solution
    val stats: List<Triple<String, String, String>> // Value, Title, Desc
)

data class HeroData(
    val headerText: AnnotatedString,
    val summary: String,
    val totalProductionApps: Int,
    val specialistCard: String
)

data class AboutMeData(
    val leftText: String,
    val rightText: AnnotatedString
)
