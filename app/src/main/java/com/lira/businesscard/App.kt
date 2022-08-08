package com.lira.businesscard

import android.app.Application
import com.lira.businesscard.model.local.AppDatabase
import com.lira.businesscard.model.local.BusinessCardRepository

class App: Application() {

    val db by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(db.businessCardDao()) }

}