package chp10;
import java.util.*;
public class TestGroup {

	public static void main(String[] args) {
		List teamList = new ArrayList();
		teamList.add("���ص���");
		teamList.add("����͢");
		teamList.add("�Ĵ�����");
		teamList.add("����ά��");
		teamList.add("����");
		teamList.add("��������");
		teamList.add("�ձ�");
		teamList.add("����");
		teamList.add("�й�");
		teamList.add("������");
		teamList.add("����");
		teamList.add("����ʱ");
		teamList.add("����");
		teamList.add("����¡");
		teamList.add("�鶼��˹");
		teamList.add("�����");
		
		List groupList = new ArrayList();
		groupList.add(new ArrayList());
		groupList.add(new ArrayList());
		groupList.add(new ArrayList());
		groupList.add(new ArrayList());
		
		for(int i = 0; i<teamList.size(); i++){
			//дһ��ѭ��
			//groupIndexΪ��ǩ���
			//�������С������ʱ������Ҫ���³�ǩ��ֱ���ҵ�һ��δ����С��
			int groupIndex = 0;
			do{
				groupIndex = getRandom();
			}while( ((List)groupList.get(groupIndex)).size() == 4 );
			
			List l = (List) groupList.get(groupIndex);
			l.add(teamList.get(i));
		}
		
		
		//��ӡ
		for(int i = 0; i<groupList.size(); i++){
			System.out.println("Group " + (char)('A' + i));
			List l = (List) groupList.get(i);
			for(int j = 0; j<l.size(); j++){
				System.out.print(l.get(j) + "\t");
			}
			System.out.println();
		}
		
	}
	
	public static int getRandom(){
		int n = (int)(Math.random() * 100 % 4);
		return n;
	}

}
