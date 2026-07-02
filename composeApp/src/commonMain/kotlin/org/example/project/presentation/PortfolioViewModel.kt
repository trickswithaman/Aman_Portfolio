package org.example.project.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.example.project.PortfolioConstants
import org.example.project.components.calculateExperience

enum class PortfolioSection(val title: String, val index: Int) {
    Home("Home", 0),
    About("About", 1),
    Skills("Skills", 2),
    Projects("Projects", 3),
    Experience("Experience", 4),
    Contact("Contact", 5)
}

sealed class PortfolioDestination {
    object Main : PortfolioDestination()
    object AllProjects : PortfolioDestination()
    data class ProjectDetail(val projectName: String) : PortfolioDestination()
}

data class PortfolioUiState(
    val selectedSection: PortfolioSection = PortfolioSection.Home,
    val navigationStack: List<PortfolioDestination> = listOf(PortfolioDestination.Main),
    val totalExperience: String = ""
)

class PortfolioViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PortfolioUiState())
    val uiState: StateFlow<PortfolioUiState> = _uiState.asStateFlow()

    init {
        val experience = calculateExperience(
            PortfolioConstants.START_YEAR,
            PortfolioConstants.START_MONTH
        )
        _uiState.update { it.copy(totalExperience = experience) }
    }

    fun onSectionSelected(section: PortfolioSection) {
        _uiState.update {
            it.copy(
                selectedSection = section,
                navigationStack = listOf(PortfolioDestination.Main)
            )
        }
    }

    fun onProjectSelected(projectName: String?) {
        _uiState.update {
            val newStack = it.navigationStack.toMutableList()
            if (projectName != null) {
                newStack.add(PortfolioDestination.ProjectDetail(projectName))
            } else {
                if (newStack.last() is PortfolioDestination.ProjectDetail) {
                    newStack.removeAt(newStack.size - 1)
                }
            }
            it.copy(navigationStack = newStack)
        }
    }

    fun setShowAllProjects(show: Boolean) {
        _uiState.update {
            val newStack = it.navigationStack.toMutableList()
            if (show) {
                if (PortfolioDestination.AllProjects !in newStack) {
                    newStack.add(PortfolioDestination.AllProjects)
                }
            } else {
                newStack.removeAll { dest -> dest is PortfolioDestination.AllProjects || dest is PortfolioDestination.ProjectDetail }
            }
            it.copy(navigationStack = newStack)
        }
    }

    fun onBackPress() {
        _uiState.update {
            if (it.navigationStack.size > 1) {
                it.copy(navigationStack = it.navigationStack.dropLast(1))
            } else {
                it
            }
        }
    }
}