package com.example.appealscomposetraineeproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appealscomposetraineeproject.ui.MainFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}

//@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun MainScreen() {
//    Surface {
//        val pagerState = rememberPagerState(2)
//
//        Column {
//            TopAppBarCompose()
//            CustomTabLayout(pagerState)
//            PagerContent(pagerState = pagerState)
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MainTheme {
//        MainScreen()
//    }
//}