package AM;

import java.util.*;

public class Common_Manager {
	public static void main(String[] args) {
        Employee samir = new Employee("samir");
        Employee dom = new Employee("dom");
        Employee michael = new Employee("michael");


        Employee peter = new Employee("peter");
        Employee porter = new Employee("porter");
        Employee bob = new Employee("bob");

        dom.reporters = Arrays.asList(bob, peter, porter);

        Employee milton = new Employee("milton");
        Employee nina = new Employee("nina");

        peter.reporters = Arrays.asList(milton, nina);

        Employee bill = new Employee("bill");
        bill.reporters = Arrays.asList(dom, samir, michael);
        
        Employee test = new Employee("test");

        System.out.println(commonManager(bill, milton, nina));//peter
        System.out.println(commonManager(bill, nina, porter));//dom
        System.out.println(commonManager(bill, nina, samir));//bill
        System.out.println(commonManager(bill, peter, nina));//peter
        System.out.println(commonManager(bill, peter, test));//null
        System.out.println(commonManager(bill, bill, bill));//bill
    }
	
	static Employee closestCommonManager1(Employee root, Employee a, Employee b)
	{
		if(a == root || b == root)
			return root;
			
		int count = 0;
		Employee temp = null;
		
		for(Employee iter : root.reporters)
		{
			Employee res = closestCommonManager1(iter, a, b);
			if(res != null)
			{
				count++;
				temp = res;
			}
		}
		
		if(count == 2)
			return root;
			
		return temp;
	}
	
	// ............
	public static Employee commonManager(Employee ceo, Employee e1, Employee e2) {
        if (ceo == null || e1 == null || e2 == null)//corner case
            return null;
        
        if (!isContain(ceo, e1) || !isContain(ceo, e2))//if e1 or e2 do not belong to the organization
            return null;
        
        Queue<Employee> q = new LinkedList<>();
        q.add(ceo);
        Employee res = null;
        while (!q.isEmpty()) {
            Employee employee = q.poll();
            if (isContain(employee, e1) && isContain(employee, e2)) {
            	res = employee;
                for (Employee em : employee.reporters) {
                    q.add(em);
                }
            }
        }
        return res;
    }
	
	//manager is contain the employee or not
	public static boolean isContain(Employee manager, Employee employee) {
        if (manager == null)
            return false;        
        if (manager.name == employee.name)
            return true;
        
        if (manager.reporters == null || manager.reporters.size() == 0)
            return false;
        for (Employee e : manager.reporters) {
        	if (isContain(e, employee))
        		return true;
        }
        return false;
    }
}

class Employee {
    String name;
    List<Employee> reporters;

    public Employee(String name) {
        this.name = name;
        reporters = new ArrayList<Employee>();
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + '}';
    }
}
