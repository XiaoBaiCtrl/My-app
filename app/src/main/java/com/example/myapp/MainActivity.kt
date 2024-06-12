package com.example.myapp
//111
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import com.example.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(Color(0xFFD0E8D0)), // 背景颜色
//            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f)) // 添加一个权重为1的Spacer来推开顶部内容

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo), // 替换为实际的图片资源ID
                contentDescription = "Android Logo",
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFF004165), shape = CircleShape)
                    .padding(16.dp),
                contentScale = ContentScale.Fit,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Jennifer Doe",
                fontSize = 32.sp,
                fontWeight = FontWeight.Light,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Android Developer Extraordinaire",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF2E8B57) // 绿色文本
            )
        }

        Spacer(modifier = Modifier.weight(1f)) // 再添加一个权重为1的Spacer来推开底部内容

        ContactInfo(modifier = Modifier.padding(bottom = 32.dp)) // 调整底部的距离
    }
}

@Composable
fun ContactInfo(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.Start, // 左对齐
        modifier = Modifier.padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Bottom,
    ) {
        ContactInfoItem(icon = Icons.Default.Phone, info = "+11 (123) 444 555 666")
        ContactInfoItem(icon = Icons.Default.Share, info = "@AndroidDev")
        ContactInfoItem(icon = Icons.Default.Email, info = "jen.doe@android.com")
    }
}

@Composable
fun ContactInfoItem(icon: ImageVector, info: String) {
    Row(
        modifier = Modifier.padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically // 垂直方向上居中对齐
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF2E8B57),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = info,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.alignByBaseline(),
            fontWeight=FontWeight.Bold
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyAppTheme {
        BusinessCard()
    }
}

