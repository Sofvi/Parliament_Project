package com.suvilai.ex5.data

import com.suvilai.ex5.ParliamentMember.ParliamentMembersData.members


class Datasource {

    fun member(): List<String> {
        return members.map { it.fullName() }.toSet().toList().sorted()
    }
}