# Introduction

Demo a real use case of TreeMap in a fintech platform which uses TreeMap to store daily pricing of securities (or stocks). 
The pricing data of a date can be null (due to no transaction at this date), at this case, the data of the nearest date should be used.

Let's dig into an example with the daily pricing of stock **"NT2"** from **01-Jan-2023 to 15-Jan-2023** as below.

| Date        | Price           |
| ------------- |:-------------:| 
| 01/01/2023      | 100.5 | 
| 02/01/2023      | 100.6      |
| 03/01/2023 | 100.7      |
| 07/01/2023 | 99      |
| 09/01/2023 | 102      |
| 15/01/2023 | 87.4      |


Within this example, if we bought 50 units of this stock on 07/01/2023, the value of this transaction is _****99x50=4,950****_. 

However, if we bought 30 units on 11/01/2023, there is no price data on 11/01/2023 so the price data on 09/01/2023 is selected (the nearest day of 11/01/2023). 
Hence, the value of this transaction is _**102x30=3,060**_.

## Tech stack

JDK 11, Gradle

## How to get started?
After building the project, we can run the **DailyPricingServiceTest** to see how this demo works.