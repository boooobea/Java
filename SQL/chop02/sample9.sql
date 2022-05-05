-----------------------------------------------
--       *** SELECT 문의 기본문법 구조 *** 
-- SELECT [DISTINCT] { *, column[AS][alias], ...}
-- FROM <테이블명>
-- WHERE <pridicates>
-----------------------------------------------
-- 1. Logical Operators(논리연산자)
-- (1) AND(그리고):두 조건을 모두 만족하는 경우 TRUE
-- (2) OR(또는):두 조건중, 한가지만 만족해도 TRUE
-- (3) NOT(부정):지정된 조건이 아닌 데이터를 검색
-----------------------------------------------
-- 1. NOT 연산자
-- Select rows from a Table
SELECT 
    last_name, 
    job_id,
    salary
FROM
    employees
--WHERE
--    NOT salary < 20000;
--WHERE
--    (NOT salary < 20000);
WHERE
    NOT (salary<20000);     --조건식의 경계를 확실하게 표시하기 위해서() 
    
-- 2. NOT IN 연산자
SELECT
    last_name, 
    job_id,
    salary
FROM
    employees
WHERE
    salary NOT IN( 9000,8000,6000 );      --실전에서 사용
--WHERE
--    NOT (salary IN(9000,8000,6000));
    
-- 3. NOT LIKE 연산자
SELECT 
    last_name,
    job_id,
    salary
FROM 
    employees
WHERE
    last_name NOT LIKE 'J%';    --실전에서 사용 
--WHERE
--    NOT last_name LIKE 'J%';
--WHERE
--    NOT (last_name LIKE 'J%');
    
-- 4. NOT BETWEEN a AND b 연산자 
--  NOT(a <= x <= b) --> (x>a, x>b)
SELECT 
    last_name, 
    job_id,
    salary
FROM
    employees
WHERE
    salary NOT BETWEEN 2400 AND 20000;        --실전에서 사용
--WHERE
--    NOT (salary BETWEEN 2400 AND 20000);

-- 5. IN NULL 연산자(******)
SELECT
    last_name, 
    job_id,
    salary,
    commission_pct
FROM 
    employees
WHERE
    commission_pct = NULL;
--WHERE
--    commission_pct IS NULL;
--WHERE
--    nvl(commission_pct, -1) = -1;     --INDEX 사용불가

-- 6. IS NOT NULL 연산자 
SELECT 
    last_name,
    job_id,
    salary,
    manager_id
FROM
    employees
WHERE
    manager_id IS NOT NULL;