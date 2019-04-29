
package com.mteam.presentation

import com.mteam.model.Member

interface MembersView : BaseView {
  var isUpdating: Boolean
  fun onUpdate(members: List<Member>)
}