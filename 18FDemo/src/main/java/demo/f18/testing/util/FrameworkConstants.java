package demo.f18.testing.util;

public class FrameworkConstants {
	

	
	
	// Log Level constants
		public static final String PAGE="page";
		public static final String TEST="test";
		public static final String METHOD="method";
		public static final String QUESTION = "question";
		public static final String TO_DO_STEPS = "to-do-steps";
		public static final String ASSERTS = "asserts";
		public static final String TESTCASE = "testcase";
		public static final String PRE_CONDITION = "precondition" ;
		public static final String BUG = "bug" ;
		public static final String BUG_GIT_HUB_LINK = "Bug_Git_hub_link" ;
		public static final String MANUAL_TESTING_NOTE = "Manual-Testing-Note";
		 
		 
		public static final String ERROR = "error" ;
		public static final String FAILURE = "failure" ;
		public static final String WARNING = "warning";
		
		
		
		//Messages 

		public static final	String LAST_AVAILABLE_COLUMN_IS_NOT_EMPTY_AND_NEW_COLUMN_CAN_NOT_BE_INSERTED = 
					"Last available column is not empty and a new column cannot be inserted" ;
			
		public static final	String EXPECTED_MATCH_NOT_FOUND = "Expected match not found" ;
		public static final	String INVITATION_WAS_SENT_SUCCESSFULLY  = "Invitation was sent successfully" ;
			
			// Permissions 
		public static final	String YOU_ARE_A_READER_AND_THEREFORE_NOT_ALLOWED_TO_CREATE_OR_EDIT_THE_PROJECT_DATA_IN_ANY_WAY = 
					"You are a Reader and therefore not allowed to create or edit the project data in any way.";


		
	//	IValues 

		public static final	 String UNDEFINED = "undefined";
		public static final	 String EMPTY_STRING = "";
		public static final	 String FALSE = "false";
		public static final	 String TRUE ="true";
		public static final	 String SPACES_THREE = "   ";
		public static final	 String SPACE = " " ;
		public static final	 String ON = "On";
		public static final	 String OFF = "Off";
		public static final	 String HTML_SPACE = "&nbsp;";
		public static final	 String HTML_SPACE_THREE = "&nbsp;&nbsp;&nbsp;";
			 
		public static final	 String LEFT = "Left" ;
		public static final	 String RIGTH = "Right" ;
		public static final	 String UP = "Up" ;
		public static final	 String DOWN = "Down" ;
		public static final	 String NaN = "NaN" ;
			 
		public static final	 String DEFAULT = "Default" ;
		public static final	 String NONE = "None";
		
		
		
		// Waits Milli seconds
			//All waits are in milli seconds
		public static final	int SMALLEST = 300;
		public static final	int SMALL = 500;
		public static final	int MEDIUM = 700;
		public static final	int LARGE = 1000;
		public static final	int LARGE_2 = 1500;
		public static final	int LARGEST = 2000;
		public static final	int LARGEST_2 = 3000;
		public static final	int __50 = 50 ;
		public static final	int __100 = 100;
		public static final	int __110 = 110;
		public static final	int __120 = 120 ;
		public static final	int __130 = 130 ;
		public static final	int __140 = 140 ;
		public static final	int __150 = 150 ;
		public static final	int __200 = 200 ;
		public static final	int __250 = 250 ;
		public static final	int __300 = 300 ;
		public static final	int __350 = 350 ;
		public static final	int __400 = 400 ;
		public static final	int __450 = 450 ;
		public static final	int __500 = 500 ;
	
		// IWarningMessages 
		public static final	String CELL_IS_EMPTY = "Cell is empty";
		public static final	String OUTPUT_CELL_IS_EMPTY = "Output cell is empty";
		public static final	String OUTPUT_IS_NOT_DRIVEN_BY_ANY_CELL = "Output is not driven by any cell";
		public static final	String INPUT_CELL_IS_EMPTY = "Input cell is empty";
		public static final	String THIS_ACTION_WOULD_OVERWRITE_SOME_CELLS_OPERATION_CANCELLED = 
					"This action would overwrite some cells: operation cancelled.\n\nEmpty cells and retry.";
			
		public static final String THE_FORMULA_IS_NOT_COMPLETE_YET = "The formula is not complete yet." ;
		public static final String DIFFERENCE_IN_WARNING_MESSAGE_FOUND  = "Difference in warning message found" ;


}
