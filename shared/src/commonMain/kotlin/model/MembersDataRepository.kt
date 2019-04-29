
package com.mteam.model

import com.mteam.api.GitHubApi
import com.mteam.api.UpdateProblem
import com.mteam.presentation.DataRepository
import kotlinx.serialization.UnstableDefault

class MembersDataRepository(private val api: GitHubApi) : DataRepository {

  override var members: List<Member>? = null

  override var onRefreshListeners: List<() -> Unit> = emptyList()

  @UnstableDefault
  override suspend fun update() {
    val newMembers = try {
      api.getMembers()
    } catch (cause: Throwable) {
      throw UpdateProblem()
    }

    if (newMembers != members) {
      members = newMembers
      callRefreshListeners()
    }
  }


  private fun callRefreshListeners() {
    onRefreshListeners.forEach { it() }
  }
}