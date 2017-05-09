package queue;

import java.util.ArrayList;
import java.util.List;

/**
 * ��Queue��ʵ��Josephus����
 * ��������ϵ����⵱�У� N�����ݾ�������һ��ͬ�������ַ�ʽ��������������  N����Χ��һȦ��λ�ü�Ϊ0��N-1���� ���Ҵӵ�һ���˱����� ����M���˻ᱻɱ���� ֱ�����һ����������
 * �÷�������һ��List�� �����˱�ɱ���˵Ĵ���
 * @author liuxin
 *
 */
public class Josephus {
	
	public static List<Integer> execute(int n, int m){
		
		Queue<Integer> q=new Queue<>();
		for(int i=0;i<n;i++)
		{
			q.enQueue(i);
		}
		List<Integer> result=new ArrayList<>();
		int i=0;
		while(!q.isEmpty())
		{
			int x=q.deQueue();
			if(++i%m==0)
			{
				result.add(x);
			}else{
				q.enQueue(x);
			}
		}
		return result;
	}
	
}
