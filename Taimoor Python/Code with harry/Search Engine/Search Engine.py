# Practice Problem 7(Code with Harry)
import time

with open("Search Engine.txt") as f:
    # text = f.readlines()
    # for i in range(len(text)):
    #     if "\n" in text[i]:
    #         x = text[i].replace("\n", " ")
    #         text.pop(i)
    #         text.insert(i, x)
    txt = f.read()
    text = txt.split("\n")

last_Results = []
found_Results = []
total_result = 0
query = input("Enter your Query String : ")
a = time.time()
queries = query.split()
for i in queries:
    max_count = 0
    query_check_1 = i.lower()
    for j in text:
        text_check_2 = j.lower()
        if query_check_1 in text_check_2:
            # total_result += 1
            found_Results.append(j)
            pre_check = text_check_2.count(query_check_1)  # this var counts the query in text how many times
            if pre_check > max_count:
                max_count = pre_check
    while max_count != 0:
        for k in found_Results:
            new_double_check_1 = k.lower()
            counts = new_double_check_1.count(query_check_1)
            if max_count == counts and (k not in last_Results):
                last_Results.append(k)
                total_result += 1
        max_count -= 1


b = time.time()
print(f"Search Results are {total_result} Results ({time.time() - a} Seconds)")
for i in range(len(last_Results)):
    print(f"{i + 1}. {last_Results[i]}")
