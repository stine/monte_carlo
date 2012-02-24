// Naive, dirty calculation of Pi via Monte Carlo.
// LA Coding Dojo, Feb 22, 2012
// Matt Stine

#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

// Returns a random value in [-1.0,1.0).
float randInterval()
{
  return ((float)rand()/(RAND_MAX/2) - 1.0f);
}

// Returns magnitude of a random point on square of width 2.
float randMagnitude()
{
  float x, y;
  x = randInterval();
  y = randInterval();
  return sqrt(x*x + y*y);
}

int main(int argc, char **argv)
{
  unsigned long i = 0;
  unsigned long inside = 0;
  unsigned long total = 10000000;
  srand(time(NULL));
  for (i = 0; i < total; ++i) if (randMagnitude() < 1.0f) ++inside;
  printf("Iterations: %u,  Pi: %f\n", total, 4 * (float)inside / total);
  return 0;
}

