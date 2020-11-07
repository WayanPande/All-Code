#include <iostream>
#include <conio.h>

using namespace std;
int x;
void findmod(float bil[], int n, float mod[])
{
	int total[100];
	int k = 1;
	x = 0;
	//untuk mengurutkan secara ascending
	for (int c = 0; c < n; c++)
	{
		for (int i = (n - 1); i >= 0; i--)
		{
			if (bil[i] < bil[i - 1])
			{
				int temp;
				temp = bil[i];
				bil[i] = bil[i - 1];
				bil[i - 1] = temp;
			}
		}
	}
	//menghitung berapa kali muncul tiap angka
	for (int c = 0; c < n; c++)
	{
		total[c] = 0;
		for (int i = 0; i < n; i++)
		{
			if (bil[c] == bil[i])
			{
				total[c]++;
			}
		}
	}
	//menentukan nilai yang paling sering muncul
	for (int c = 0; c < n; c++)
	{
		if (total[c] > k)
		{
			k = total[c];
		}
	}
	//jika modus lebih dari satu
	for (int c = 0; c < n; c++)
	{
		if (x == 0)
			mod[x] = 0;
		else
			mod[x] = mod[x - 1];
		if (total[c] == k)
		{
			if (bil[c] != mod[x])
			{
				mod[x] = bil[c];
				x++;
			}
		}
	}

	//Jika Semua angka muncul sama banyak
	int z = 0;
	for (int c = 0; c < n; c++)
	{
		if (total[c] == k)
		{
			z++;
		}
	}
	if (z == n)
	{
		x = 0;
	}
}

int main()
{
	int n;
	float bil[100];
	float mod[100];
	cout << "Banyak N : ";
	cin >> n;
	for (int c = 0; c < n; c++)
	{
		cout << "Nilai " << (c + 1) << " : ";
		cin >> bil[c];
	}
	cout << endl;
	findmod(bil, n, mod);
	if (x == 0)
		cout << "Tidak Ada Modus!" << endl;
	else
	{
		cout << "Modus : ";
		for (int c = 0; c < x; c++)
		{
			cout << mod[c] << " ";
		}
	}
	getch();
}