
package com.mteam.multiplatform

import android.app.Application
import com.mteam.api.GitHubApi
import com.mteam.model.MembersDataRepository
import com.mteam.presentation.DataRepository

class GitHubKMPApplication : Application() {

  val dataRepository: DataRepository by lazy {
    MembersDataRepository(GitHubApi())
  }
}