package id.eureka.dotakoe.core.domain.usecase

import id.eureka.dotakoe.core.data.source.Resource
import id.eureka.dotakoe.core.domain.model.Team
import kotlinx.coroutines.flow.Flow

interface TeamUseCase {
    fun getPlayerTeam(teamId: String): Flow<Resource<Team>>
}