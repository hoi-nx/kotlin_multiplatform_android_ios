
package com.mteam.presentation

import com.mteam.model.Member


interface DataRepository {
  val members: List<Member>?
  var onRefreshListeners: List<() -> Unit>

  suspend fun update()
}