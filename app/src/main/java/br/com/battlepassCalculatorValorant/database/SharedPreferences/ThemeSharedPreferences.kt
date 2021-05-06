package br.com.battlepassCalculatorValorant.database.SharedPreferences

import android.content.Context
import br.com.battlepassCalculatorValorant.R
import br.com.battlepassCalculatorValorant.model.Singleton.ManagerSharedPreferences

class ThemeSharedPreferences(context: Context) {

    private val mSharedPreferences: MySharedPreferences =
        ManagerSharedPreferences.getInstance(context)
    private val keyThemeStatus = context.getString(R.string.themeStatus)

    var darkMode = mSharedPreferences[keyThemeStatus, 2]
        set(value) = mSharedPreferences.set(keyThemeStatus, value)
}