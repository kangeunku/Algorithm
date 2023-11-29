-- 코드를 입력하세요
select I.REST_ID, I.REST_NAME, I.FOOD_TYPE, I.FAVORITES,I.ADDRESS, R.SCORE
from
    REST_INFO I join
(SELECT rest_id, ROUND(AVG(REVIEW_SCORE),2) as score
FROM
    REST_REVIEW
group by rest_id) R
on i.rest_id = r.rest_id
where i.address like "서울%"
order by r.score desc, i.favorites desc;