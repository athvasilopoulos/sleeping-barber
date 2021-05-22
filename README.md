# Sleeping Barber

This is a GUI-based Java solution for the Sleeping Barber(SB) problem, a classic inter-process communication and synchronization problem.

<center>
  <img src=media/example.gif width="400">
</center>

## Description

This implementation of the SB problem is subject to the following restrictions:

1. The barber can serve one person at a time
2. The barber rests at the waiting room while he is waiting for customers
3. The barber needs to take a break at the waiting room for every 10 cuts he gives.
4. Due to COVID regulations, only 4 people, including the barber, can sit at the waiting room at the same time. The rest of the people have to wait outside.
