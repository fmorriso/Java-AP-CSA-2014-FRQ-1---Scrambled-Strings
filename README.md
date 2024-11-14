# CsAwesome - 4.14. Free Response - String Scramble

Write a method that scrambles words in a phrase that have the letter 'A' in them followed by a letter that is not 'A'.

## Tools Used

| Tool     |  Version |
|:---------|---------:|
| Java     | 23.0.0.0 |
| IntelliJ | 2024.3.0 |
| VSCode   |   1.95.2 |

## Change History

| Date       | Description           |
|:-----------|:----------------------|
| 2024-11-13 | Initial creation      |
| 2024-11-14 | Add for-loop solution |


## References

* [scrambleWord Sample Solution](https://www.apcomputersciencetutoring.com/scrambleword-scrambleorremove-free-response-answer/)
* [CsAwesome - 4.14. Free Response - String Scramble A¶](https://runestone.academy/ns/books/published/LPHS_2024-25/Unit4-Iteration/FRQstringScrambleA.html)
* [ AP Computer Science A - 2014 Free-Response Questions (PDF)](https://secure-media.collegeboard.org/digitalServices/pdf/ap/ap14_frq_computer_science_a.pdf)

## Instruction Summary

<ol type="a">
	<li>Write the method <em>scrambleWord</em>, which takes a given word and returns a string that contains a scrambled version of the word according to the following rules.</li>
	<ul>
		<li>The scrambling process begins at the first letter of the word and continues from left to right.</li>
		<li>If two consecutive letters consist of an "A" followed by a letter that is not an "A", then the two letters are swapped in the resulting string.</li>
		<li>Once the letters in two adjacent positions have been swapped, neither of those two positions can be involved in a future swap.</li>
	</ul>
	<li>Write the method <em>scrambleOrRemove</em>, which replaces each word in the parameter wordList with its scrambled version and removes any words that are unchanged after scrambling. The relative ordering of the entries in wordList remains the same as before the call to scrambleOrRemove</li>
</ol>
