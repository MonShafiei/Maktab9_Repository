import java.util.Scanner;

public class Suduku {
	
	
	Scanner input = new Scanner(System.in);
	String st ;//= input.next();
	int row = 0 , column = 0;
	char ch;
	int number_of_valid_number = 3;	//	count of number 
	String[][] array = new String[3][3];
	
	int[] state_array = new int[3*3];
	
	public void sudu()
	{
		for(int i=0;i<state_array.length;i++)
		{
			state_array[i] = 1;
		}
		int state_array_length = 0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if((number_of_valid_number - i -j) > 1)
				{
					
				state_array[state_array_length] = number_of_valid_number - i -j;
				
				state_array_length++;
				
				}				
			}
		}
		
		//int number_state_of_row_1_column_1 = 3;
		//int number_state_of_row_1_column_2 = 2;
		//int number_state_of_row_2 = 2;
		//int result_state = number_state_of_row_1_column_1 * number_state_of_row_1_column_2 * number_state_of_row_2 ;
		
		for(int i = 0 ; i<3 ;i++)
		{
			for(int j =0 ;j<3;j++)
			{
				array[i][j] = "x";
			}
		}
		
		
		state_array_length = 0;
		
		do
		{
			
			//st = input.next().toString();
			st = input.next();
			//System.out.println(st);
			ch = st.charAt(0);
			if(ch == '1' || ch == '2' || ch == '3' || ch == 'x' || ch == 'X')
			//if(st == "1" || st == "2" || st == "3" || st == "x" || st == "X")
			{
				array[row][column] = st;
				column++;
				//System.out.println("test");
			}
			
			else 
			{
				System.out.println("The input was invalid");
				System .exit(0);
			}
			
			if(column > 2)
			{			
				
				row++;
				column = 0;
				input.nextLine();
			}
			if(row > 2)
			{
				row = 0;
				column = 0;
				break;
			}
			//break;
		}while (input.hasNext());
		
		for(int i = 0 ; i<3 ;i++)
		{
			for(int j =0 ;j<3;j++)
			{
				ch = array[i][j].charAt(0);
				if(ch == '1' || ch == '2' || ch == '3') 
				{
					for(int k = 0 ; k<3 ;k++)
					{
						if((ch == array[k][j].charAt(0) && k != i ) || (ch == array[i][k].charAt(0) && k != j ))
						{
							System.out.println("The input was replay");
							System .exit(0);
						}
					}
				}
			}
		}
		
		
		for(int i = 0 ; i<3 ;i++)
		{
			for(int j =0 ;j<3;j++)
			{
				ch = array[i][j].charAt(0);
				if(ch == '1' || ch == '2' || ch == '3' && (j != 2)) 
				{
					state_array[state_array_length]= 1;
					state_array_length++;
				}
			}
		}
			
		
		int result_state = 1 ;
				
				
		for(int i=0;i<state_array.length;i++)
		{
			//System.out.print(state_array[i]);
			result_state = result_state * state_array[i];
			//System.out.print(result_state);
		}
		
		System.out.println(result_state);
		/*
		do
		{
			x = input.nextInt();
			System.out.println(x);
		}while (input.hasNext());
		*/
		
		//st = input.next();
		//System.out.println(st);
	}


}
