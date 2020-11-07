/* Tower of Hanoi - Animated */
/* KRNathan */

/* upto 10 discs */
/* Play mode & Demo mode */
/* adjustable speed for animation */

/*  Tested. OK. */
/*  compiler used for testing: Turbo C++ 3.0  */

#include <stdio.h>
#include <conio.h>

#define NMAX 10
#define blankline "                                                                                   "

int n, disc, count, speed;
int least[11] = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023};
int disccol[10][3] = {15, 40, 65,
                      14, 39, 64,
                      13, 38, 63,
                      12, 37, 62,
                      11, 36, 61,
                      10, 35, 60,
                      9, 34, 59,
                      8, 33, 58,
                      7, 32, 57,
                      6, 31, 56};
int curdiscstatus[10];
int currow[10], curcol[10];
int curstackstatus[3][10];

void delay(int speed)
{
    long int x, y, a, b;
    a = (long)20000 / speed;
    b = (long)20000 / speed;
    for (x = 0l; x < a; x++)
        for (y = 0l; y < b; y++)
            ;
}

void drawbox()
{
    int i, j;
    gotoxy(1, 1);
    textcolor(12);
    cprintf("%c", 201);
    for (i = 2; i < 79; i++)
        cprintf("%c", 205);
    cprintf("%c", 187);
    for (i = 2; i < 15; i++)
    {
        gotoxy(1, i);
        cprintf("%c", 186);
        gotoxy(79, i);
        cprintf("%c", 186);
    }
    gotoxy(1, 15);
    cprintf("%c", 200);
    for (i = 2; i < 79; i++)
        cprintf("%c", 205);
    cprintf("%c", 188);
    textcolor(7);
}

void erase(disc, row, col)
{
    int i;
    textcolor(7);
    for (i = 0; i < (disc + 1) * 2; i++)
    {
        gotoxy(col++, row);
        cprintf(" ");
    }
}

void showdisc(disc, row, col)
{
    int i;
    textcolor(7);
    for (i = 0; i < (disc + 1) * 2; i++)
    {
        gotoxy(col + i, row);
        cprintf("%c", 223);
    }
}

void makemove(fromstack, tostack)
{
    int i, d1, d2, r1, r2, c1, c2, dir;
    for (i = 0; i < 10; i++)
    {
        if (curstackstatus[fromstack][i] == 1)
        {
            d1 = i;
            break;
        }
    }
    r1 = currow[d1];
    c1 = disccol[d1][fromstack];
    r2 = 0;
    for (i = 0; i < 10; i++)
    {
        if (curstackstatus[tostack][i] == 1)
        {
            d2 = i;
            r2 = currow[d2] - 1;
            break;
        }
    }
    if (r2 == 0)
        r2 = 12;
    c2 = disccol[d1][tostack];
    if (c2 > c1)
        dir = 1;
    else
        dir = -1;

    while (r1 > 2) /* move up */
    {
        erase(d1, r1, c1);
        r1--;
        showdisc(d1, r1, c1);
        delay(speed);
    }
    r1 = 2;
    do /* move sideways */
    {
        erase(d1, 2, c1);
        c1 = c1 + dir;
        showdisc(d1, 2, c1);
        delay(speed);
    } while (c1 != c2);

    while (r1 < r2) /* move down */
    {
        erase(d1, r1, c2);
        r1++;
        showdisc(d1, r1, c2);
        delay(speed);
    }
    currow[d1] = r2;
    curcol[d1] = c2;
    curdiscstatus[d1] = tostack;
    curstackstatus[fromstack][d1] = 0;
    curstackstatus[tostack][d1] = 1;
}

int validatemove(fromstack, tostack)
{
    int i, d11 = 0, d12 = 0, d21 = 0, d22 = 0;
    if (fromstack < 0 || fromstack > 2)
        return 0;
    if (tostack < 0 || tostack > 2)
        return 0;

    for (i = 0; i < 10; i++)
    {
        if (curstackstatus[fromstack][i] == 1)
        {
            d11 = 1;
            d12 = i;
            break;
        }
    }
    for (i = 0; i < 10; i++)
    {
        if (curstackstatus[tostack][i] == 1)
        {
            d21 = 1;
            d22 = i;
            break;
        }
    }
    if (d11 == 0)
        return 0;
    if (d21 == 0 || d12 < d22)
        return 1;
    else
        return 0;
}

int checkend()
{
    int i, end = 0;
    for (i = 0; i < n; i++)
    {
        if (curdiscstatus[i] == 2)
            end++;
    }
    if (end != n)
        end = 0;

    return end;
}

void initialise()
{
    int i, j = 12;
    clrscr();
    drawbox();
    gotoxy(8, 1);
    textcolor(14);
    cprintf(" Tower of Hanoi ");
    gotoxy(67, 1);
    cprintf(" KRN ");
    textcolor(7);
    for (i = 0; i < 10; i++)
    {
        curdiscstatus[i] = 0;
        curstackstatus[0][i] = 0;
        curstackstatus[1][i] = 0;
        curstackstatus[2][i] = 0;
        currow[i] = 0;
        curcol[i] = 0;
    }
    for (i = n - 1; i >= 0; i--)
    {
        showdisc(i, j, disccol[i][0]);
        curdiscstatus[i] = 0;
        curstackstatus[0][i] = 1;
        currow[i] = j;
        curcol[i] = disccol[i][0];
        j--;
    }

    textcolor(9);
    for (i = 0; i < 3; i++)
    {
        gotoxy(disccol[9][i] - 1, 13);
        for (j = 0; j < 22; j++)
            cprintf("%c", 205);
    }
    textcolor(10);
    for (i = 0; i < 3; i++)
    {
        gotoxy(disccol[9][i] + 6, 14);
        cprintf("Stack #%d", i + 1);
    }
    textcolor(7);
    gotoxy(1, 16);
    cprintf("Goal: Move all discs from Stack #1 to Stack #3.\n\r");
    cprintf("Rules: 1. In each step, remove topmost disc of any stack & place it\n\r");
    cprintf("               on top of other existing discs in another stack.\n\r");
    cprintf("       2. A larger disc cannot be placed on top of a smaller disc.\n\r");
    cprintf("       3. Stack #2 can be used as temporary location.\n\r");
    count = 0;
}

void play()
{
    int i, r, valid = 0, end = 0;
    int s1, s2;
    while (1)
    {
        r = 21;
        textcolor(7);
        for (i = 0; i < 4; i++)
        {
            gotoxy(1, r++);
            cprintf(blankline);
        }
        gotoxy(1, 21);
        cprintf("Play Mode.\n\r");
        cprintf("No. of Discs (1 to 10) : ");
        scanf("%d", &n);
        if (n >= 1 && n <= NMAX)
            break;
        gotoxy(1, 23);
        textcolor(14 + 128);
        cprintf("Minimum 1 disc, Maximum 10 discs.");
        textcolor(7);
        cprintf("  Try again.");
        getch();
    }

    while (1)
    {
        gotoxy(1, 23);
        cprintf("Animation Speed (1 to 10) : ");
        scanf("%d", &speed);
        if (speed >= 1 && speed <= 10)
            break;
        gotoxy(1, 24);
        textcolor(14 + 128);
        cprintf("Speed range is 1 to 10.");
        textcolor(7);
        cprintf("  Try again.");
        getch();
        gotoxy(1, 23);
        textcolor(7);
        cprintf(blankline);
        gotoxy(1, 24);
        cprintf(blankline);
    }

    initialise();
    gotoxy(1, 21);
    cprintf("Play Mode.  %d discs. Speed %d.", n, speed);
    while (!end)
    {
        valid = 0;
        while (!valid)
        {
            textcolor(7);
            gotoxy(1, 22);
            cprintf(blankline);
            gotoxy(1, 23);
            cprintf(blankline);
            gotoxy(1, 24);
            cprintf(blankline);
            gotoxy(1, 22);
            cprintf("Step #%d: Move disc from Stack # [1/2/3]: ", ++count);
            scanf("%d", &s1);
            gotoxy(1, 23);
            cprintf("                     to Stack # [1/2/3]: ");
            scanf("%d", &s2);

            valid = validatemove(s1 - 1, s2 - 1);
            if (valid)
                break;

            gotoxy(1, 24);
            textcolor(14 + 128);
            cprintf("Invalid Move.");
            textcolor(7);
            cprintf("  Try again.");
            getch();
            count--;
        }
        makemove(s1 - 1, s2 - 1);
        end = checkend();
    }
    gotoxy(1, 22);
    cprintf(blankline);
    gotoxy(1, 23);
    cprintf(blankline);
    gotoxy(1, 23);
    textcolor(14 + 128);
    if (count == least[n])
        cprintf("Congrats. You did it in least possible moves (%d).", count);
    else
        cprintf("You did it in %d steps. Least possible moves = %d", count, least[n]);
    textcolor(7);
    gotoxy(1, 24);
    cprintf("Press any key to go back to Menu...");
    getch();
}

void solver()
{
    int i, j, gamend = 0, sum1;
    int s1, s2, dir;
    int d, d11, d12, d21, d22;
    int sum2[3] = {0, 0, 0};

    if (n % 2 == 0)
        dir = 1;
    else
        dir = -1;

    while (!gamend)
    {
        /*  move  smallest disc    */

        d = 0;
        s1 = curdiscstatus[d];
        s2 = s1 + dir;
        if (s2 < 0)
            s2 = 2;
        else if (s2 > 2)
            s2 = 0;
        gotoxy(1, 23);
        cprintf("Step #%d: Move Disc #%d from Stack #%d to Stack #%d\n", ++count, d + 1, s1 + 1, s2 + 1);
        makemove(s1, s2);

        /* check if game end */
        sum1 = 0;
        for (i = 0; i < n; i++)
        {
            sum1 += curdiscstatus[i];
            sum2[i] = 0;
        }
        for (i = 0; i < n; i++)
        {
            sum2[0] += curstackstatus[0][i];
            sum2[1] += curstackstatus[1][i];
            sum2[2] += curstackstatus[2][i];
        }
        if (sum1 == n * 2 && sum2[0] == n && sum2[1] == 0 && sum2[2] == 0)
        {
            gamend = 1;
            break;
        }

        switch (curdiscstatus[0])
        {
        case 0:
            s1 = 1;
            s2 = 2;
            break;
        case 1:
            s1 = 2;
            s2 = 0;
            break;
        case 2:
            s1 = 0;
            s2 = 1;
            break;
        }

        d11 = 0;
        d12 = 0;
        d21 = 0;
        d22 = 0;
        for (i = 0; i < n; i++)
        {
            if (curstackstatus[s1][i] == 1)
            {
                d11 = 1;
                d12 = i;
                break;
            }
        }
        for (j = 0; j < n; j++)
        {
            if (curstackstatus[s2][j] == 1)
            {
                d21 = 1;
                d22 = j;
                break;
            }
        }
        if (d11 == 0 && d21 == 0)
        {
            gamend = 1;
            break;
        }

        /*    make a valid move between other 2 stacks    */
        if (d21 == 0)
        {
            d = d12;
        }
        else if (d11 == 0)
        {
            j = s1;
            s1 = s2;
            s2 = j;
            d = d22;
        }
        else if (d22 < d12)
        {
            j = s1;
            s1 = s2;
            s2 = j;
            d = d22;
        }
        else if (d12 < d22)
            d = d12;

        gotoxy(1, 23);
        cprintf(blankline);
        gotoxy(1, 23);
        cprintf("Step #%d: Move Disc #%d from Stack #%d to Stack #%d\n", ++count, d + 1, s1 + 1, s2 + 1);
        makemove(s1, s2);

    } /* loop while not game end  */
}

void demo()
{
    int i, r;
    while (1)
    {
        r = 21;
        textcolor(7);
        for (i = 0; i < 4; i++, r++)
        {
            gotoxy(1, r);
            cprintf(blankline);
        }
        gotoxy(1, 21);
        cprintf("Demo Mode.\n\r");
        cprintf("No. of discs (1 to 10) : ");
        scanf("%d", &n);
        if (n >= 1 && n <= NMAX)
            break;
        gotoxy(1, 23);
        textcolor(14 + 128);
        cprintf("Minimum 1 disc; Maximum 10 discs.");
        textcolor(7);
        cprintf("  Please try again.");
        getch();
    }

    while (1)
    {
        gotoxy(1, 23);
        cprintf("Animation Speed (1 to 10) : ");
        scanf("%d", &speed);
        if (speed >= 1 && speed <= 10)
            break;
        gotoxy(1, 24);
        textcolor(14 + 128);
        cprintf("Speed range is 1 to 10.");
        textcolor(7);
        cprintf("  Try again.");
        getch();
        gotoxy(1, 23);
        textcolor(7);
        cprintf(blankline);
        gotoxy(1, 24);
        cprintf(blankline);
    }

    initialise();
    gotoxy(1, 21);
    cprintf("Demo mode.  %d Discs.  Speed %d.", n, speed);
    solver();
    gotoxy(1, 24);
    textcolor(14);
    cprintf("Done in %d steps.", count);
    textcolor(7);
    cprintf("  Press any key to go back to Menu....");
    textcolor(7);
    getch();
}

void main()
{
    int quit = 0;
    char ch;
    textmode(3);
    while (!quit)
    {
        quit = 0;
        n = 10;
        speed = 3;
        initialise();
        printf("Demo will do it in minimum no. of steps.\n");
        printf("Want to Play, See a Demo or Quit ? [p/d/q] : ");
        ch = getche();
        if (ch == 'P' || ch == 'p')
        {
            play();
        }
        else if (ch == 'D' || ch == 'd')
            demo();
        else
            quit = 1;
    }
    textcolor(14 + 128);
    gotoxy(1, 24);
    cprintf("Thank you for using this program. Hope you liked it. Goodbye !");
    textcolor(7);
    getch();
    return;
}

/* ------------ eof ------------- */