package com.example.bank_masr_task_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bank_masr_task_login.ui.theme.Bank_Masr_Task_LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bank_Masr_Task_LoginTheme {
                Bank_Masr_Task_Login()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bank_Masr_Task_Login() {
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val isLoginEnabled = text.isNotEmpty() && password.isNotEmpty()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 72.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.bm_icon),
                contentDescription = "Bank Masr Logo",
                modifier = Modifier.size(120.dp)
            )
            Text(
                text = stringResource(R.string.language),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                modifier = Modifier.clickable {}
            )
        }

        // Username and Password section
        Column(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text(text = stringResource(R.string.username)) },
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.DarkGray,
                    focusedBorderColor = Color.Gray
                ),
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = stringResource(R.string.password)) },
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (passwordVisible)
                        painterResource(id = R.drawable.visibility)
                    else painterResource(id = R.drawable.unvisibility)

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(painter = icon, contentDescription = "Toggle password visibility")
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.DarkGray,
                    focusedBorderColor = Color.Gray
                ),
            )
        }

        // Forgot Pass Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, start = 8.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = stringResource(R.string.forgot),
                modifier = Modifier.clickable {},
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                textDecoration = TextDecoration.Underline,
                color = Color.Red
            )
        }


        // Login Btn
        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(vertical = 8.dp),
            shape = MaterialTheme.shapes.small,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isLoginEnabled) Color(
                    red = 189,
                    green = 52,
                    blue = 70,
                    alpha = 255
                ) else Color.Gray,
            )
        ) {
            Text(
                text = stringResource(R.string.login),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,

                )
        }
//help section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = stringResource(R.string.need_help),
                modifier = Modifier.clickable { },
                fontSize = 16.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = stringResource(R.string.contact),
                modifier = Modifier.clickable {},
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                color = Color.Red
            )
        }

        // Divider
        HorizontalDivider(
            thickness = 0.5.dp,
            color = Color.Red,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Bottom Row (Icons)
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, end = 28.dp, top = 28.dp)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.our_products),
                    contentDescription = "Products",
                    modifier = Modifier
                        .size(64.dp)
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = stringResource(R.string.products),
                    textAlign = TextAlign.Center

                )
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.exchange_rate),
                    contentDescription = "Exchange rate",
                    modifier = Modifier
                        .size(64.dp)
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = stringResource(R.string.exchange),
                    textAlign = TextAlign.Center

                    )
            }


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.security_tips),
                    contentDescription = "Security tips",
                    modifier = Modifier
                        .size(64.dp)
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = stringResource(R.string.security),
                    textAlign = TextAlign.Center

                    )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.nearest_branch_or_atm),
                    contentDescription = "Nearest branch",
                    modifier = Modifier
                        .size(64.dp)
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = stringResource(R.string.nearest),
                    textAlign = TextAlign.Center

                    )
            }
        }
    }
}

    @Preview(showBackground = true, showSystemUi = true)
@Composable
fun BankLoginScreenPreview() {
    Bank_Masr_Task_Login()
}
