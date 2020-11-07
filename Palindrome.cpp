#include <bits/stdc++.h> 
#include <string.h>
#include <sstream>
#include <conio.h>
#include <windows.h>
using namespace std;


const int BLUE = 1;
const int GREEN = 2;
const int RED = 4;
const int WHITE = 15;



void changeColour(int colour)
{
	HANDLE hConsole;
	
	hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
	SetConsoleTextAttribute(hConsole, colour);
}


int main() 
{ 
	char mau;
	cout << "\n\n\n";
    cout << "      ";
   
  
	changeColour(RED);
	cout << "PROGRAM";
	Sleep(1000);
	
	changeColour(GREEN);
	cout << " PENGUJI";
	Sleep(1000);
	
	changeColour(WHITE);
	cout << " INPUTAN";
	Sleep(1000);
	
	changeColour(BLUE);
	cout << " PALINDROME";
	Sleep(1000);
	
	changeColour(WHITE);
	cout << "\n\n\n";
	int judul = 0;
	main:
	
	if (judul > 0)
	{
	cout << "\n\n\n";
    cout << "      ";
	changeColour(RED);
	cout << "PROGRAM";
	
	changeColour(GREEN);
	cout << " PENGUJI";
	
	changeColour(WHITE);
	cout << " INPUTAN";
	
	changeColour(BLUE);
	cout << " PALINDROME";
	
	changeColour(WHITE);
	cout << "\n\n\n";	
    }
	char str[100];
    
	cout << "\t Masukkan kata atau kalimat: ";
	changeColour(WHITE);
	gets (str);
    int panjang = strlen(str);
    
    for (int i=0;i<panjang;i++)
	{
		if (str[i] == ' ' || str[i] == ',' || str[i] == '.')
		{
				str[i] = str[i+1];
			for (int j=i+1;j<panjang;j++)
			{
				str[j] = str[j+1];
			}
		}
	}
	
	string cek = str;
  	string kata;
  	stringstream kata2;
  	kata2 << str;
  	kata2 >> kata;
    
    reverse(cek.begin(), cek.end()); 
   
  	int x = kata.compare(cek);
	if (x != 0	)
	{
		changeColour(RED);
		cout << "\t    ____________________"<<endl;
		cout << "\t    |                  |"<<endl;
		cout << "\t    | TIDAK PALINDROME |"<<endl;
		cout << "\t    |                  |"<<endl;
		cout << "\t    |__________________|"<<endl;
		changeColour(WHITE);
	
	}else
	{
		changeColour(GREEN);
		cout << "\t    ____________________"<<endl;
		cout << "\t    |                  |"<<endl;
		cout << "\t    |    PALINDROME    |"<<endl;
		cout << "\t    |                  |"<<endl;
		cout << "\t    |__________________|"<<endl;
		changeColour(WHITE);
	} 
	cout << "\n\n\tIngin menginput lagi? (y/t)";
 	mau=getch();
	if(mau == 'y')  
	{
		system("cls");
		judul++;
  		goto main;
    }
    return 0; 
} 