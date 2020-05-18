select * from tab;

--- emp : �������
--- dept : �μ�����
--- bonus : �ӽ����̺�
--- salgrade : �޿� ���̺�

-- ���̺��� ���� Ȯ�� : desc ���̺��̸�

desc emp;
desc dept;
desc salgrade;

--������ �˻� ����
SELECT ename, sal, deptno, empno
    
FROM emp; -- ���̺� �̸�

select * from dept;

SELECT deptno
FROM dept;

--select�� ����� ���ο� ���̺��̴�.
--�÷��� ��� ������ �����ϴ�. +, -, *, /, mod�Լ� �̿�

SELECT
    *
FROM emp;

SELECT ename, sal, sal + comm
    
FROM emp;

select ename, sal, sal + 500
from emp;

select ename, sal, sal - 100
from emp;

select ename, sal, sal * 12
from emp;

select ename, sal, sal / 2
from emp;

-- null���� Ȯ��
SELECT ename, job, sal, comm, SAL*12, SAL*12+COMM
FROM emp;

-- null �� ġȯ �Լ�: nvl(�÷���, �⺻��)
-- �⺻���� �÷��� �������� �ڷ��� ���ƾ� �Ѵ�.

SELECT ename, job, sal, nvl(comm,0), sal*12, sal*12+nvl(comm,0) as total+
FROM emp;

-- �����ͺ��̽��� ���ڿ� ǥ�� -> ���� ����ǥ�� �̿�
-- '���ڿ�'
-- ���ڿ��� �ٿ��� ����ϴ� ���� -> ||

SELECT ename || ' is a ' || job as massage
    
FROM emp;

select ename, job from emp;

-- ��� �÷��� �ߺ��� �����ϰ� �ϳ����� ���: distinct
select distinct deptno
from emp;

SELECT distinct deptno, job
    
FROM emp order by deptno;