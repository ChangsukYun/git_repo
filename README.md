# 데이터 전처리 (2)

## #01. 필요한 모듈 참조 및 샘플 데이터 준비


```python
from pandas import DataFrame
from sample import grade_dic
```


```python
성적표 = DataFrame(grade_dic, index = ['철수', '영희', '민철', '수현', '호영'])
성적표
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>국어</th>
      <th>영어</th>
      <th>수학</th>
      <th>과학</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>철수</td>
      <td>98</td>
      <td>NaN</td>
      <td>88.0</td>
      <td>64.0</td>
    </tr>
    <tr>
      <td>영희</td>
      <td>88</td>
      <td>90.0</td>
      <td>62.0</td>
      <td>72.0</td>
    </tr>
    <tr>
      <td>민철</td>
      <td>92</td>
      <td>70.0</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <td>수현</td>
      <td>63</td>
      <td>60.0</td>
      <td>31.0</td>
      <td>70.0</td>
    </tr>
    <tr>
      <td>호영</td>
      <td>120</td>
      <td>50.0</td>
      <td>NaN</td>
      <td>88.0</td>
    </tr>
  </tbody>
</table>
</div>



## #02. 행, 열의 순서 변경

### 1) 컬럼(열)의 순서 변경
- 지정된 순서대로 **열**이 재정렬 된 결과가 반환된다
- 원본은 변화 없음. 결과가 적용된 복사본이 생성된다.


```python
df1 = 성적표.reindex(columns=['국어', '수학', '과학', '영어'])
df1
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>국어</th>
      <th>수학</th>
      <th>과학</th>
      <th>영어</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>철수</td>
      <td>98</td>
      <td>88.0</td>
      <td>64.0</td>
      <td>NaN</td>
    </tr>
    <tr>
      <td>영희</td>
      <td>88</td>
      <td>62.0</td>
      <td>72.0</td>
      <td>90.0</td>
    </tr>
    <tr>
      <td>민철</td>
      <td>92</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>70.0</td>
    </tr>
    <tr>
      <td>수현</td>
      <td>63</td>
      <td>31.0</td>
      <td>70.0</td>
      <td>60.0</td>
    </tr>
    <tr>
      <td>호영</td>
      <td>120</td>
      <td>NaN</td>
      <td>88.0</td>
      <td>50.0</td>
    </tr>
  </tbody>
</table>
</div>



### 2) 인텍스(행) 순서 변경
- 지정된 순서대로 **행**이 재정렬된 결과가 반환된다.
- 원본은 변화 없음. 결과가 적용된 복사본이 생성된다.


```python
df2 = 성적표.reindex(index=['철수', '민철', '호영', '영희', '수현'])
df2
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>국어</th>
      <th>영어</th>
      <th>수학</th>
      <th>과학</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>철수</td>
      <td>98</td>
      <td>NaN</td>
      <td>88.0</td>
      <td>64.0</td>
    </tr>
    <tr>
      <td>민철</td>
      <td>92</td>
      <td>70.0</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <td>호영</td>
      <td>120</td>
      <td>50.0</td>
      <td>NaN</td>
      <td>88.0</td>
    </tr>
    <tr>
      <td>영희</td>
      <td>88</td>
      <td>90.0</td>
      <td>62.0</td>
      <td>72.0</td>
    </tr>
    <tr>
      <td>수현</td>
      <td>63</td>
      <td>60.0</td>
      <td>31.0</td>
      <td>70.0</td>
    </tr>
  </tbody>
</table>
</div>



### 3) 컬럼과 인덱스 순서 동시 변경


```python
df3 = 성적표.reindex(columns=['국어', '수학', '과학', '영어'],
                  index=['철수', '민철', '호영', '영희', '수현'])
df3
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>국어</th>
      <th>수학</th>
      <th>과학</th>
      <th>영어</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>철수</td>
      <td>98</td>
      <td>88.0</td>
      <td>64.0</td>
      <td>NaN</td>
    </tr>
    <tr>
      <td>민철</td>
      <td>92</td>
      <td>NaN</td>
      <td>NaN</td>
      <td>70.0</td>
    </tr>
    <tr>
      <td>호영</td>
      <td>120</td>
      <td>NaN</td>
      <td>88.0</td>
      <td>50.0</td>
    </tr>
    <tr>
      <td>영희</td>
      <td>88</td>
      <td>62.0</td>
      <td>72.0</td>
      <td>90.0</td>
    </tr>
    <tr>
      <td>수현</td>
      <td>63</td>
      <td>31.0</td>
      <td>70.0</td>
      <td>60.0</td>
    </tr>
  </tbody>
</table>
</div>



## #03. 행, 열의 이름 변경
- "기존이름 : 새이름" 형식의 딕셔너리로 지정
- 원본은 변화없음. 결과가 적용된 복사본이 생성된다.

### 1)  컬럼이름 변경하기


```python
df4 = 성적표.rename(columns={'국어':'kor', '영어':'eng', '수학':'math', '과학':'sinc'})
df4
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>kor</th>
      <th>eng</th>
      <th>math</th>
      <th>sinc</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>철수</td>
      <td>98</td>
      <td>NaN</td>
      <td>88.0</td>
      <td>64.0</td>
    </tr>
    <tr>
      <td>영희</td>
      <td>88</td>
      <td>90.0</td>
      <td>62.0</td>
      <td>72.0</td>
    </tr>
    <tr>
      <td>민철</td>
      <td>92</td>
      <td>70.0</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <td>수현</td>
      <td>63</td>
      <td>60.0</td>
      <td>31.0</td>
      <td>70.0</td>
    </tr>
    <tr>
      <td>호영</td>
      <td>120</td>
      <td>50.0</td>
      <td>NaN</td>
      <td>88.0</td>
    </tr>
  </tbody>
</table>
</div>



### 2) 인덱스 이름 변경하기


```python
df5 = 성적표.rename(index={'영희':'yh', '수현':'sh', '호영':'hy', '철수':'cs', '민철':'mc'})
df5
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>국어</th>
      <th>영어</th>
      <th>수학</th>
      <th>과학</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>cs</td>
      <td>98</td>
      <td>NaN</td>
      <td>88.0</td>
      <td>64.0</td>
    </tr>
    <tr>
      <td>yh</td>
      <td>88</td>
      <td>90.0</td>
      <td>62.0</td>
      <td>72.0</td>
    </tr>
    <tr>
      <td>mc</td>
      <td>92</td>
      <td>70.0</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <td>sh</td>
      <td>63</td>
      <td>60.0</td>
      <td>31.0</td>
      <td>70.0</td>
    </tr>
    <tr>
      <td>hy</td>
      <td>120</td>
      <td>50.0</td>
      <td>NaN</td>
      <td>88.0</td>
    </tr>
  </tbody>
</table>
</div>



### 3) 컬럼과 인덱스 동시 변경 + 원본에 즉시 반영
- `inplace=True` 파라미터를 사용하면 리턴값 없이 원본에 바로 적용된다.
- `reindex()`함수는 inplace 파라미터를 지원하지 않음.


```python
# 성적표의 복사본을 하나 생성함
df = 성적표.copy()

# 복사본을 가지고 컬럼, 인덱스, 변경 수행
df.rename(columns={'국어':'kor', '영어':'eng', '수학':'math', '과학':'sinc'},
         index={'영희':'yh', '수현':'sh', '호영':'hy', '철수':'cs', '민철':'mc'},
         inplace=True)
df
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>kor</th>
      <th>eng</th>
      <th>math</th>
      <th>sinc</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>cs</td>
      <td>98</td>
      <td>NaN</td>
      <td>88.0</td>
      <td>64.0</td>
    </tr>
    <tr>
      <td>yh</td>
      <td>88</td>
      <td>90.0</td>
      <td>62.0</td>
      <td>72.0</td>
    </tr>
    <tr>
      <td>mc</td>
      <td>92</td>
      <td>70.0</td>
      <td>NaN</td>
      <td>NaN</td>
    </tr>
    <tr>
      <td>sh</td>
      <td>63</td>
      <td>60.0</td>
      <td>31.0</td>
      <td>70.0</td>
    </tr>
    <tr>
      <td>hy</td>
      <td>120</td>
      <td>50.0</td>
      <td>NaN</td>
      <td>88.0</td>
    </tr>
  </tbody>
</table>
</div>



## #04. `reindex()` 함수를 사용한 외부 데이터 처리시의 전처리
외부에서 가져온 형태의 데이터(csv, xlsx 파일 등)의 경우 인덱스 이름이 지정되지 않고, 
모든 값이 컬럼으로 형성도기 때문에 특정 컬럼을 인덱스로 지정하는 전처리가 요구된다.

### 1) 엑셀 파일 가져오기
#### 엑셀 파일 처리를 위해 필요한 패키지 추가 로드


```python
from pandas import ExcelFile
```

#### 엑셀 데이터를 데이터 프레임으로 가져오기

각 행에 지역이라는 문자열 데이터가 포함되어 있기 때문에 이 컬럼을 인덱스로 변경해야 한다.
> DataFrame을 그래프로 표현할 때 인덱스 값이 x축의 라벨로 사용되기 때문


```python
xlsx = ExcelFile("http://itpaper.co.kr/demo/python/children_house.xlsx")
엑셀데이터 = xlsx.parse(xlsx.sheet_names[0])
엑셀데이터
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>지역</th>
      <th>2014</th>
      <th>2015</th>
      <th>2016</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>0</td>
      <td>전국(계)</td>
      <td>43742</td>
      <td>42517</td>
      <td>41084</td>
    </tr>
    <tr>
      <td>1</td>
      <td>서울</td>
      <td>6787</td>
      <td>6598</td>
      <td>6368</td>
    </tr>
    <tr>
      <td>2</td>
      <td>부산</td>
      <td>1957</td>
      <td>1971</td>
      <td>1937</td>
    </tr>
    <tr>
      <td>3</td>
      <td>대구</td>
      <td>1588</td>
      <td>1539</td>
      <td>1483</td>
    </tr>
    <tr>
      <td>4</td>
      <td>인천</td>
      <td>2308</td>
      <td>2278</td>
      <td>2231</td>
    </tr>
    <tr>
      <td>5</td>
      <td>광주</td>
      <td>1260</td>
      <td>1264</td>
      <td>1238</td>
    </tr>
    <tr>
      <td>6</td>
      <td>대전</td>
      <td>1698</td>
      <td>1669</td>
      <td>1584</td>
    </tr>
    <tr>
      <td>7</td>
      <td>울산</td>
      <td>946</td>
      <td>934</td>
      <td>895</td>
    </tr>
    <tr>
      <td>8</td>
      <td>세종</td>
      <td>160</td>
      <td>216</td>
      <td>250</td>
    </tr>
    <tr>
      <td>9</td>
      <td>경기</td>
      <td>13259</td>
      <td>12689</td>
      <td>12120</td>
    </tr>
    <tr>
      <td>10</td>
      <td>강원</td>
      <td>1257</td>
      <td>1227</td>
      <td>1180</td>
    </tr>
    <tr>
      <td>11</td>
      <td>충북</td>
      <td>1229</td>
      <td>1230</td>
      <td>1208</td>
    </tr>
    <tr>
      <td>12</td>
      <td>충남</td>
      <td>2053</td>
      <td>1988</td>
      <td>1974</td>
    </tr>
    <tr>
      <td>13</td>
      <td>전북</td>
      <td>1654</td>
      <td>1623</td>
      <td>1562</td>
    </tr>
    <tr>
      <td>14</td>
      <td>전남</td>
      <td>1242</td>
      <td>1238</td>
      <td>1251</td>
    </tr>
    <tr>
      <td>15</td>
      <td>경북</td>
      <td>2212</td>
      <td>2130</td>
      <td>2102</td>
    </tr>
    <tr>
      <td>16</td>
      <td>경남</td>
      <td>3533</td>
      <td>3349</td>
      <td>3158</td>
    </tr>
    <tr>
      <td>17</td>
      <td>제주</td>
      <td>599</td>
      <td>574</td>
      <td>543</td>
    </tr>
  </tbody>
</table>
</div>



### 2) 인덱스를 지정하기 위한 데이터 전처리 수행
#### 지역명을 리스트로 추출


```python
지역이름list = list(엑셀데이터['지역'])
지역이름list
```




    ['전국(계)',
     '서울',
     '부산',
     '대구',
     '인천',
     '광주',
     '대전',
     '울산',
     '세종',
     '경기',
     '강원',
     '충북',
     '충남',
     '전북',
     '전남',
     '경북',
     '경남',
     '제주']



#### `{인덱스번호: 지역명}` 형식의 딕셔너리 구성


```python
지역이름dict = {}
for i, v in enumerate(지역이름list):
    지역이름dict[i]=v
    
지역이름dict    
```




    {0: '전국(계)',
     1: '서울',
     2: '부산',
     3: '대구',
     4: '인천',
     5: '광주',
     6: '대전',
     7: '울산',
     8: '세종',
     9: '경기',
     10: '강원',
     11: '충북',
     12: '충남',
     13: '전북',
     14: '전남',
     15: '경북',
     16: '경남',
     17: '제주'}



#### 준비된 딕셔너리를 데이터프레임에 적용


```python
어린이집 = 엑셀데이터.rename(index=지역이름dict)
어린이집
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>지역</th>
      <th>2014</th>
      <th>2015</th>
      <th>2016</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>전국(계)</td>
      <td>전국(계)</td>
      <td>43742</td>
      <td>42517</td>
      <td>41084</td>
    </tr>
    <tr>
      <td>서울</td>
      <td>서울</td>
      <td>6787</td>
      <td>6598</td>
      <td>6368</td>
    </tr>
    <tr>
      <td>부산</td>
      <td>부산</td>
      <td>1957</td>
      <td>1971</td>
      <td>1937</td>
    </tr>
    <tr>
      <td>대구</td>
      <td>대구</td>
      <td>1588</td>
      <td>1539</td>
      <td>1483</td>
    </tr>
    <tr>
      <td>인천</td>
      <td>인천</td>
      <td>2308</td>
      <td>2278</td>
      <td>2231</td>
    </tr>
    <tr>
      <td>광주</td>
      <td>광주</td>
      <td>1260</td>
      <td>1264</td>
      <td>1238</td>
    </tr>
    <tr>
      <td>대전</td>
      <td>대전</td>
      <td>1698</td>
      <td>1669</td>
      <td>1584</td>
    </tr>
    <tr>
      <td>울산</td>
      <td>울산</td>
      <td>946</td>
      <td>934</td>
      <td>895</td>
    </tr>
    <tr>
      <td>세종</td>
      <td>세종</td>
      <td>160</td>
      <td>216</td>
      <td>250</td>
    </tr>
    <tr>
      <td>경기</td>
      <td>경기</td>
      <td>13259</td>
      <td>12689</td>
      <td>12120</td>
    </tr>
    <tr>
      <td>강원</td>
      <td>강원</td>
      <td>1257</td>
      <td>1227</td>
      <td>1180</td>
    </tr>
    <tr>
      <td>충북</td>
      <td>충북</td>
      <td>1229</td>
      <td>1230</td>
      <td>1208</td>
    </tr>
    <tr>
      <td>충남</td>
      <td>충남</td>
      <td>2053</td>
      <td>1988</td>
      <td>1974</td>
    </tr>
    <tr>
      <td>전북</td>
      <td>전북</td>
      <td>1654</td>
      <td>1623</td>
      <td>1562</td>
    </tr>
    <tr>
      <td>전남</td>
      <td>전남</td>
      <td>1242</td>
      <td>1238</td>
      <td>1251</td>
    </tr>
    <tr>
      <td>경북</td>
      <td>경북</td>
      <td>2212</td>
      <td>2130</td>
      <td>2102</td>
    </tr>
    <tr>
      <td>경남</td>
      <td>경남</td>
      <td>3533</td>
      <td>3349</td>
      <td>3158</td>
    </tr>
    <tr>
      <td>제주</td>
      <td>제주</td>
      <td>599</td>
      <td>574</td>
      <td>543</td>
    </tr>
  </tbody>
</table>
</div>




```python
# 딕셔너리를 사용하지 않고, 직접 대입해도 됨
어린이집2 = 엑셀데이터.rename(index=엑셀데이터['지역'])
어린이집2
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>지역</th>
      <th>2014</th>
      <th>2015</th>
      <th>2016</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>전국(계)</td>
      <td>전국(계)</td>
      <td>43742</td>
      <td>42517</td>
      <td>41084</td>
    </tr>
    <tr>
      <td>서울</td>
      <td>서울</td>
      <td>6787</td>
      <td>6598</td>
      <td>6368</td>
    </tr>
    <tr>
      <td>부산</td>
      <td>부산</td>
      <td>1957</td>
      <td>1971</td>
      <td>1937</td>
    </tr>
    <tr>
      <td>대구</td>
      <td>대구</td>
      <td>1588</td>
      <td>1539</td>
      <td>1483</td>
    </tr>
    <tr>
      <td>인천</td>
      <td>인천</td>
      <td>2308</td>
      <td>2278</td>
      <td>2231</td>
    </tr>
    <tr>
      <td>광주</td>
      <td>광주</td>
      <td>1260</td>
      <td>1264</td>
      <td>1238</td>
    </tr>
    <tr>
      <td>대전</td>
      <td>대전</td>
      <td>1698</td>
      <td>1669</td>
      <td>1584</td>
    </tr>
    <tr>
      <td>울산</td>
      <td>울산</td>
      <td>946</td>
      <td>934</td>
      <td>895</td>
    </tr>
    <tr>
      <td>세종</td>
      <td>세종</td>
      <td>160</td>
      <td>216</td>
      <td>250</td>
    </tr>
    <tr>
      <td>경기</td>
      <td>경기</td>
      <td>13259</td>
      <td>12689</td>
      <td>12120</td>
    </tr>
    <tr>
      <td>강원</td>
      <td>강원</td>
      <td>1257</td>
      <td>1227</td>
      <td>1180</td>
    </tr>
    <tr>
      <td>충북</td>
      <td>충북</td>
      <td>1229</td>
      <td>1230</td>
      <td>1208</td>
    </tr>
    <tr>
      <td>충남</td>
      <td>충남</td>
      <td>2053</td>
      <td>1988</td>
      <td>1974</td>
    </tr>
    <tr>
      <td>전북</td>
      <td>전북</td>
      <td>1654</td>
      <td>1623</td>
      <td>1562</td>
    </tr>
    <tr>
      <td>전남</td>
      <td>전남</td>
      <td>1242</td>
      <td>1238</td>
      <td>1251</td>
    </tr>
    <tr>
      <td>경북</td>
      <td>경북</td>
      <td>2212</td>
      <td>2130</td>
      <td>2102</td>
    </tr>
    <tr>
      <td>경남</td>
      <td>경남</td>
      <td>3533</td>
      <td>3349</td>
      <td>3158</td>
    </tr>
    <tr>
      <td>제주</td>
      <td>제주</td>
      <td>599</td>
      <td>574</td>
      <td>543</td>
    </tr>
  </tbody>
</table>
</div>



#### 필요없어진 '지역'컬럼 삭제


```python
어린이집.drop(['지역'], axis=1, inplace=True)   # axis=1 : 열단위 삭제
어린이집
```




<div>
<style scoped>
    .dataframe tbody tr th:only-of-type {
        vertical-align: middle;
    }

    .dataframe tbody tr th {
        vertical-align: top;
    }

    .dataframe thead th {
        text-align: right;
    }
</style>
<table border="1" class="dataframe">
  <thead>
    <tr style="text-align: right;">
      <th></th>
      <th>2014</th>
      <th>2015</th>
      <th>2016</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>전국(계)</td>
      <td>43742</td>
      <td>42517</td>
      <td>41084</td>
    </tr>
    <tr>
      <td>서울</td>
      <td>6787</td>
      <td>6598</td>
      <td>6368</td>
    </tr>
    <tr>
      <td>부산</td>
      <td>1957</td>
      <td>1971</td>
      <td>1937</td>
    </tr>
    <tr>
      <td>대구</td>
      <td>1588</td>
      <td>1539</td>
      <td>1483</td>
    </tr>
    <tr>
      <td>인천</td>
      <td>2308</td>
      <td>2278</td>
      <td>2231</td>
    </tr>
    <tr>
      <td>광주</td>
      <td>1260</td>
      <td>1264</td>
      <td>1238</td>
    </tr>
    <tr>
      <td>대전</td>
      <td>1698</td>
      <td>1669</td>
      <td>1584</td>
    </tr>
    <tr>
      <td>울산</td>
      <td>946</td>
      <td>934</td>
      <td>895</td>
    </tr>
    <tr>
      <td>세종</td>
      <td>160</td>
      <td>216</td>
      <td>250</td>
    </tr>
    <tr>
      <td>경기</td>
      <td>13259</td>
      <td>12689</td>
      <td>12120</td>
    </tr>
    <tr>
      <td>강원</td>
      <td>1257</td>
      <td>1227</td>
      <td>1180</td>
    </tr>
    <tr>
      <td>충북</td>
      <td>1229</td>
      <td>1230</td>
      <td>1208</td>
    </tr>
    <tr>
      <td>충남</td>
      <td>2053</td>
      <td>1988</td>
      <td>1974</td>
    </tr>
    <tr>
      <td>전북</td>
      <td>1654</td>
      <td>1623</td>
      <td>1562</td>
    </tr>
    <tr>
      <td>전남</td>
      <td>1242</td>
      <td>1238</td>
      <td>1251</td>
    </tr>
    <tr>
      <td>경북</td>
      <td>2212</td>
      <td>2130</td>
      <td>2102</td>
    </tr>
    <tr>
      <td>경남</td>
      <td>3533</td>
      <td>3349</td>
      <td>3158</td>
    </tr>
    <tr>
      <td>제주</td>
      <td>599</td>
      <td>574</td>
      <td>543</td>
    </tr>
  </tbody>
</table>
</div>



## #05. 정렬


```python

```


```python

```
