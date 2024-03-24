select count(id) as FISH_COUNT, MAX(IFNULL(length, 10)) as MAX_LENGTH, FISH_TYPE from FISH_INFO
group by FISH_TYPE
having sum(length) / count(*) >= 33
order by
    FISH_TYPE ASC