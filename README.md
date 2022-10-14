# UkrainianNumberToWord
A simple Jetpack Compose app that converts numbers to the corresponding Ukrainian spelling.

There are still a few things to fix:

1. When the TextField is "empty" it still shows the last number used. That's because of the regex used to ignore special characters.
2. It should use Double instead of Long so it allows decimals, though it's not really useful.

The app has two classes, the main one with the composables, and a second class with the function to convert into spelling, which may have import conflicts if used in the same class as composables.

![0](https://user-images.githubusercontent.com/16231154/195762077-4c97587a-c101-4ded-b5aa-92774eed2a64.png)
![1](https://user-images.githubusercontent.com/16231154/195762082-085b6cce-af5f-4ebb-9016-284a39e2de66.png)
![2](https://user-images.githubusercontent.com/16231154/195762083-69e16769-497f-4183-9d97-8d57642764b3.png)
![3](https://user-images.githubusercontent.com/16231154/195762088-b7aec57f-ab6d-4c4d-ae98-cb1b23918a91.png)
