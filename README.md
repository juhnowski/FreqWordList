#Description
This program convert data file of frequency of mentioning words in dictionaries to javascript file.
This js contains class FreqWordList with one function fill().
```javascript
class FreqWordList {
    constructor() {
        this.version = 1;
    }
    fill() {
      ...
      localStorage.setItem('haihaya', '12');
      ...
    }
```
This js use local storage of google chrome browser for store frequency's

#Prerequisite:
- java 1.8
- data.txt near FreqWordList.jar

#Usage: java -jar FreqWordList.jar

#Format of data.txt file:
```javascript
hrāsay,verb,10. P.,10:1;25:1;41:1;55:1;98:1;144:1;156:1;184:1;187:1,9,
hrāṃ,indeclinable,ind,25:13;55:17;137:1;136:2;176:3,36,
hrī,verb,3. P.,10:1;36:1;38:1;39:4;41:1;61:1;96:1;165:1,11,
hrīkā,noun,f,96:1,1,
```

#Project's structure
This is NetBeans Java Project.
Jar file with data.txt is in the dist folder.
