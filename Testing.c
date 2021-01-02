#include <stdio.h>

void reverse(char *string, int length)
{
    int i;
    for (i = 0; i < length / 2; i++)
    {
        string[length - 1 - i] ^= string[i];
        string[i] ^= string[length - 1 - i];
        string[length - 1 - i] ^= string[i];
    }
}

int main()
{
    char string[100];
    char *ptr;
    int i = 0;
    int word = 0;
    fgets(string, 50, stdin);
    ptr = (char *)&string;

    int length = 0;
    while (*ptr++)
    {
        ++length;
    }
    reverse(string, length);

    for (i = 0; i < length; i++)
    {
        if (string[i] == ' ')
        {
            reverse(&string[word], i - word);
            word = i + 1;
        }
    }
    reverse(&string[word], i - word);
    printf("\n%s\n", string);
    return 0;
}