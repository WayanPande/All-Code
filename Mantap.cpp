#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    char kalimat[50];
    printf("Masukan kalimat: ");
    fgets(kalimat, sizeof(kalimat), stdin);
    int panjangK = strlen(kalimat) - 1;
    for (int i = panjangK; i >= -1; i--)
    {
        if (kalimat[i] == ' ' || i < 0)
        {
            int j = i;
            while (j + 1 <= panjangK)
            {
                printf("%c", kalimat[j + 1]);
                j++;
            }
            panjangK = panjangK - (panjangK - i);
        }
    }
}
