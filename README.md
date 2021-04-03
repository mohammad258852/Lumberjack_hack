# LumberJack Hach
LumberJack is a game in telegram. this code can play this game and get a good score

## how to run
1. install java and git
2. clone this repository
```
git clone 
```
3. open the game in browser run and press left arrow key two times. then get an screenshot
4. set the variables acording to the screenshot
    1. set `TreeCount` number of trees you can see in screenshot. (you can zoom out browser page to see more trees)
    2. set `LocationY` array the Y coordinate of each tree down to up. set this numbers so that the point cover the brown part of tree.
    3. set `LocationX` the X coordinate of left trees. set this number so that the point cover the brown part of tree.
    4. set `score` the score you want.
5. compile and run `Main.java` and switch to browser. you should switch in 2 seconds.(this number can be changed in code)
6. enjoy watching game

## How It Works
this code first press left key two times because in first two moves there isn't any tree.

then it capture `TreeCount` of trees and their location. It decide weather to go left or right. this will be stored in `next`

based on `next` it press left or right two times. because each tree takes two spaces.

this process continues till reach the desired score

## Config

you can change numbers to get the best result.
sometimes you should run the program more than once to work.
In slow computers it's better to increase delay time to make the program work.

#### I'll be glad to get your suggestions