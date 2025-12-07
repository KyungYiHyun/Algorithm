word = input()
word_count = []
alphabet_list = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]
for i in alphabet_list:
    word_count.append(word.count(i))
    if i in word:
        word = word.replace(i, " ")
word = word.replace(" ", "")
print(len(word) + sum(word_count))