words = ["eat","tea","tan","ate","nat","bat"]

anagrams = {}

for word in words:
	key = "".join(sorted(word))
	if key in anagrams:
		anagrams[key].append(word)
	else:
		anagrams[key] = [word]

print(list(anagrams.values()))
