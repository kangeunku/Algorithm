select count(id) as FISH_COUNT, MAX(IFNULL(length, 10)) as MAX_LENGTH, FISH_TYPE from FISH_INFO
group by FISH_TYPE
having AVG(IFNULL(length, 10)) >= 33
order by
    FISH_TYPE ASC