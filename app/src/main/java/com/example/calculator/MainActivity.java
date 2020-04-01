package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtCalculator, txtup;

    long A, B, kq;

    int checkCong,      // kiểm tra dấu cộng được ấn, (không được ấn khi checkCong =0)
            checkTru,   // kiểm tra dấu trừ được ấn, (không được ấn khi checkTru =0)
            checkNhan,  // kiểm tra dấu nhân được ấn, (không được ấn khi checkNhan =0)
            checkChia,  // kiểm tra dấu chia được ấn, (không được ấn khi checkChia =0)
            check;      /* kiểm tra các dấu phép tính và dấu bằng được ấn, (không được ấn khi check =0)
                         làm mới vùng nhập, nhập số mới*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout_calculator);

        txtCalculator = findViewById(R.id.textViewCalculator);
        txtup = findViewById(R.id.textViewUp);
        setEvenClickView();

    }

    public void setEvenClickView() {
        findViewById(R.id.buttonCE).setOnClickListener(this);
        findViewById(R.id.buttonC).setOnClickListener(this);
        findViewById(R.id.buttonBS).setOnClickListener(this);
        findViewById(R.id.buttonDivision).setOnClickListener(this);

        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button0).setOnClickListener(this);

        findViewById(R.id.buttonSum).setOnClickListener(this);
        findViewById(R.id.buttonSub).setOnClickListener(this);
        findViewById(R.id.buttonSumSub).setOnClickListener(this);
        findViewById(R.id.buttonResult).setOnClickListener(this);
        findViewById(R.id.buttonMulti).setOnClickListener(this);
        findViewById(R.id.buttonDot).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                if (check != 0) {
                    txtCalculator.setText("");
                    check = 0;
                }
                txtCalculator.append("0");
                break;

            case R.id.button1:
                if (check != 0) {
                    txtCalculator.setText("");
                    check = 0;
                }
                txtCalculator.append("1");
                break;

            case R.id.button2:
                if (check != 0) {
                    txtCalculator.setText("");
                    check = 0;
                }
                txtCalculator.append("2");
                break;

            case R.id.button3:
                if (check != 0) {
                    txtCalculator.setText("");
                    check = 0;
                }
                txtCalculator.append("3");
                break;

            case R.id.button4:
                if (check != 0) {
                    txtCalculator.setText("");
                    check = 0;
                }
                txtCalculator.append("4");
                break;

            case R.id.button5:
                if (check != 0) {
                    txtCalculator.setText("");
                    check = 0;
                }
                txtCalculator.append("5");
                break;

            case R.id.button6:
                if (check != 0) {
                    txtCalculator.setText("");
                    check = 0;
                }
                txtCalculator.append("6");
                break;

            case R.id.button7:
                if (check != 0) {
                    txtCalculator.setText("");
                    check = 0;
                }
                txtCalculator.append("7");
                break;

            case R.id.button8:
                if (check != 0) {
                    txtCalculator.setText("");
                    check = 0;
                }
                txtCalculator.append("8");
                break;

            case R.id.button9:
                if (check != 0) {
                    txtCalculator.setText("");
                    check = 0;
                }
                txtCalculator.append("9");
                break;

            case R.id.buttonC:
                txtCalculator.setText("");
                txtup.setText("");
                A = B = kq = 0;
                initCheck();
                break;

            case R.id.buttonCE:
                txtCalculator.setText("");
                break;

            case R.id.buttonBS:
                String temp = txtCalculator.getText().toString();
                if (!temp.equals("")) {
                    int len = temp.length();
                    txtCalculator.setText(temp.substring(0, len - 1));
                }
                break;

            case R.id.buttonDot:
                txtCalculator.append(".");
                break;

            case R.id.buttonDivision:
                if (txtCalculator.getText().toString().equals("")) {
                    txtup.append(0 + "/");
                } else {
                    if (checkChia > 0) {
                        if (getNumber(txtCalculator.getText().toString()) == 0) {
                            Toast.makeText(MainActivity.this, "khong the chia 0", Toast.LENGTH_SHORT).show();
                        } else {
                            A = A / getNumber(txtCalculator.getText().toString());
                        }
                    } else {
                        if (checkCong != 0 || checkTru != 0 || checkNhan != 0) {
                            Result();
                            A = kq;
                        } else {
                            A = getNumber(txtCalculator.getText().toString());
                        }
                    }
                    txtup.append(txtCalculator.getText() + "/");
                    txtCalculator.setText(A + "");

                }
                checkChia++;
                check++;
                break;

            case R.id.buttonSub:
                if (txtCalculator.getText().toString().equals("")) {
                    txtup.append(0 + "-");
                } else {
                    if (checkTru > 0) {
                        A = A - getNumber(txtCalculator.getText().toString());
                    } else {
                        if (checkCong != 0 || checkNhan != 0 || checkChia != 0) {
                            Result();
                            A = kq;
                        } else {
                            A = getNumber(txtCalculator.getText().toString());
                        }
                    }
                    txtup.append(txtCalculator.getText() + "-");
                    txtCalculator.setText(A + "");
                }
                checkTru++;
                check++;
                break;

            case R.id.buttonSum:
                if (txtCalculator.getText().toString().equals("")) {
                    txtup.append(0 + "+");
                } else {
                    if (checkCong > 0) {
                        A = A + getNumber(txtCalculator.getText().toString());
                    } else {
                        if (checkTru != 0 || checkChia != 0 || checkNhan != 0) {
                            Result();
                            A = kq;
                        } else {
                            A = getNumber(txtCalculator.getText().toString());

                        }

                    }
                    txtup.append(txtCalculator.getText() + "+");
                    txtCalculator.setText(A + "");
                }
                checkCong++;
                check++;
                break;


            case R.id.buttonMulti:
                if (txtCalculator.getText().toString().equals("")) {
                    txtup.append(0 + "*");
                } else {
                    if (checkNhan > 0) {
                        A = A * getNumber(txtCalculator.getText().toString());
                    } else {
                        if (checkCong != 0 || checkTru != 0 || checkChia != 0) {
                            Result();
                            A = kq;
                        } else {
                            A = getNumber(txtCalculator.getText().toString());
                        }
                    }
                    txtup.append(txtCalculator.getText() + "*");
                    txtCalculator.setText(A + "");
                }
                checkNhan++;
                check++;
                break;

            case R.id.buttonSumSub:
                long tmp = getNumber(txtCalculator.getText().toString());
                tmp = 0 - tmp;
                txtCalculator.setText(tmp + "");
                break;

            case R.id.buttonResult:
                if (txtCalculator.getText().toString().equals(""))
                    break;
                Result();
                txtCalculator.setText(kq + "");
                txtup.setText("");
                A = B = 0;
                initCheck();
                check++;
                break;

            default:
                break;
        }
    }

    public void Result() {
        B = getNumber(txtCalculator.getText().toString());

        if (checkCong != 0) {
            kq = A + B;
            checkCong = 0;
            check = 0;
        }

        if (checkTru != 0) {
            kq = A - B;
            checkTru = 0;
            check = 0;
        }

        if (checkChia != 0) {
            if (B == 0)
                Toast.makeText(MainActivity.this, "khong the chia 0", Toast.LENGTH_SHORT).show();
            else {
                kq = A / B;
                checkChia = 0;
                check = 0;
            }
        }

        if (checkNhan != 0) {
            kq = A * B;
            checkNhan = 0;
            check = 0;
        }
    }

    public long getNumber(String s) {
        return Long.parseLong(s);
    }

    public void initCheck() {
        check = checkChia = checkCong = checkNhan = checkTru = 0;
    }
}
