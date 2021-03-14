package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class gameController implements Initializable {

    @FXML
    private Button buttonid;
    @FXML
    private Button buttonid1;
    @FXML
    private Button buttonid2;
    @FXML
    private Button buttonid3;
    @FXML
    private Button buttonid4;
    @FXML
    private Button buttonid5;
    @FXML
    private Button buttonid6;
    @FXML
    private Text txtid;
    @FXML
    private Pane paneId;
    @FXML
    private GridPane gpane;
    @FXML
    private Circle circleiZi;
    @FXML
    private Label zgjedhLabel;
    @FXML
    private Circle circleiKuq;
    @FXML
    private Text showciliLojtar;
    @FXML
    private Button buttonFituesi;

    Rectangle r;
    int i,j;
    int cilirectangle=36;
    int cilirresht; 
    int row0=5;
    int row1=5;
    int row2=5;
    int row3=5;
    int row4=5;
    int row5=5;
    int row6=5;
    int rendilojtarit=0;
    int cilifitoi=0;
    int buttonatdisable=0;
    Circle c;
    double y=202;
    double y1=202;
    double y2=202;
    double y3=202;
    double y4=202;
    double y5=202;
    double y6=202;
    int a=0;
	int [][] array= {
			 {0,-1,-2,3,4,5,36}, // 0-0 , 0-1 ,0-1 , 0-2 
			 {6,7,8,9,10,11,37},
			 {12,13,14,15,16,17,38},
			 {18,19,20,21,22,23,39},
			 {24,25,26,27,28,29,40},
			 {30,31,32,33,34,35,41}};
	 @FXML
	 void circleClicked(MouseEvent event) {
		if(event.getSource()==circleiZi)
		{
			rendilojtarit=1;
			showciliLojtar.setText("Ju jeni lojtari me ngjyre te zeze");
			showciliLojtar.setFill(Color.BLACK);
		}
		else {
			rendilojtarit=0;
			showciliLojtar.setText("Ju jeni lojtari me ngjyre te kuqe");
			showciliLojtar.setFill(Color.RED);
		}
		circleiZi.setVisible(false);
		circleiKuq.setVisible(false);
		zgjedhLabel.setVisible(false);
		pamjaeDritares();
	}
	public void pamjaeDritares()
	{
		
		gpane.setDisable(false);
		buttonid.setDisable(false);
		buttonid1.setDisable(false);
		buttonid2.setDisable(false);
		buttonid3.setDisable(false);
		buttonid4.setDisable(false);
		buttonid5.setDisable(false);
		buttonid6.setDisable(false);
		buttonFituesi.setDisable(false);
	}
	 
    @FXML
    void buttonClicked(ActionEvent event) {
    	if(kontrolloFituesin(array) )
    	{
			Alert alert=new Alert(AlertType.CONFIRMATION);
			if(cilifitoi==1)
			{
				alert.setContentText("Lojtari me ngjyre te Kuq fitoi"); 
				alert.show();
			}
			else if(cilifitoi==2)
			{
				alert.setContentText("Lojtari me ngjyre te Zi fitoi");
				alert.show();
			}
    	}
    	else {
    	if (event.getSource()==buttonFituesi)
        {
        	if(buttonatdisable==7)
        	{
        		Alert alert=new Alert(AlertType.CONFIRMATION);
        		alert.setContentText("Loja kryhet pa fitues");
    			alert.show();
        	}
        }	
    	else if(event.getSource()==buttonid)	
    	{	
    		c=new Circle(16.5);
    		gpane.add(c, 0, 0);
    		TranslateTransition transition=new TranslateTransition();
    		transition.setDuration(Duration.seconds(1));
    		transition.setToX(0);
    		transition.setToY(y);
    		transition.setNode(c);
    		transition.play();
    		//transition.setPath(arrayRectangle.get(0));
    		mbushRrethin(rendilojtarit,c);//bone tkuqe ose tzi
    		//gpane.add(c, 0, row0);
    		y-=40.2;//y=y-40.2
    		
    		if (row0>=0)
        	{
        		
        		if(vendosNr(rendilojtarit))// nese numri osht qift me kan i kuq
        		{
        			array[row0][0]=2; //2 zi
        		}
        		else
        		{
        			array[row0][0]=1; // 1 kuq 
        		}
        		row0=row0-1;
        		if(row0<0)
        		{
        			buttonid.setDisable(true);
        			buttonatdisable+=1;
        		}
        	}
    		shfaqArray();
    		
    	}
    	
    	else if(event.getSource()==buttonid1)
    	{
    		c=new Circle(16.5);
    		gpane.add(c, 1, 0);
    		
    		TranslateTransition transition=new TranslateTransition();
    		transition.setDuration(Duration.seconds(1));
    		transition.setToX(0);
    		transition.setToY(y1);
    		transition.setNode(c);
    		transition.play();
    		//transition.setPath(arrayRectangle.get(0));
    		mbushRrethin(rendilojtarit,c);
    		//gpane.add(c, 0, row0);
    		y1-=40.2;
        	if (row1>=0)
        	{
        		if(vendosNr(rendilojtarit))
        		{
        			array[row1][1]=2; //2 zi
        		}
        		else
        		{
        			array[row1][1]=1; // 1 kuq 
        		}
        		row1=row1-1;
        		if(row1<0)
        		{
        			buttonid1.setDisable(true);
        			buttonatdisable+=1;
        		}
        		shfaqArray();
        	}
        	
    	}
    	else if(event.getSource()==buttonid2)
    	{
    		c=new Circle(16.5);
    		gpane.add(c, 2, 0);
    		
    		TranslateTransition transition=new TranslateTransition();
    		transition.setDuration(Duration.seconds(1));
    		transition.setToX(0);
    		transition.setToY(y2);
    		transition.setNode(c);
    		transition.play();
    		//transition.setPath(arrayRectangle.get(0));
    		mbushRrethin(rendilojtarit,c);
    		//gpane.add(c, 0, row0);
    		y2-=40.2;
        	if (row2>=0)
        	{
        		if(vendosNr(rendilojtarit))
        		{
        			array[row2][2]=2; //2 zi
        		}
        		else
        		{
        			array[row2][2]=1; // 1 kuq 
        		}
        	
        		row2=row2-1;
        		if(row2<0)
        		{
        			buttonid2.setDisable(true);
        			buttonatdisable+=1;
        		}
        		shfaqArray();
        	
        	}
    	}
    	else if(event.getSource()==buttonid3)
    	{
    		c=new Circle(16.5);
    		gpane.add(c, 3, 0);
    		
    		TranslateTransition transition=new TranslateTransition();
    		transition.setDuration(Duration.seconds(1));
    		transition.setToX(0);
    		transition.setToY(y3);
    		transition.setNode(c);
    		transition.play();
    		//transition.setPath(arrayRectangle.get(0));
    		mbushRrethin(rendilojtarit,c);
    		//gpane.add(c, 0, row0);
    		y3-=40.2;
        	if (row3>=0)
        	{
        		if(vendosNr(rendilojtarit))
        		{
        			array[row3][3]=2; //2 zi
        		}
        		else
        		{
        			array[row3][3]=1; // 1 kuq 
        		}
        		
        		row3=row3-1;
        		if(row3<0)
        		{
        			buttonid3.setDisable(true);
        			buttonatdisable+=1;
        		}
        		shfaqArray();
        	}
    	}
    	else if(event.getSource()==buttonid4)
    	{
    		c=new Circle(16.5);
    		gpane.add(c, 4, 0);
    		
    		TranslateTransition transition=new TranslateTransition();
    		transition.setDuration(Duration.seconds(1));
    		transition.setToX(0);
    		transition.setToY(y4);
    		transition.setNode(c);
    		transition.play();
    		//transition.setPath(arrayRectangle.get(0));
    		mbushRrethin(rendilojtarit,c);
    		//gpane.add(c, 0, row0);
    		y4-=40.2;
        	if (row4>=0)
        	{
        		if(vendosNr(rendilojtarit))
        		{
        			array[row4][4]=2; //2 zi
        		}
        		else
        		{
        			array[row4][4]=1; // 1 kuq 
        		}
        		row4=row4-1;
        		if(row4<0)
        		{
        			buttonid4.setDisable(true);
        			buttonatdisable+=1;
        		}
        		shfaqArray();
        	}
    	}
    	else if(event.getSource()==buttonid5)
    	{
    		c=new Circle(16.5);
    		gpane.add(c, 5, 0);
    		
    		TranslateTransition transition=new TranslateTransition();
    		transition.setDuration(Duration.seconds(1));
    		transition.setToX(0);
    		transition.setToY(y5);
    		transition.setNode(c);
    		transition.play();
    		//transition.setPath(arrayRectangle.get(0));
    		mbushRrethin(rendilojtarit,c);
    		//gpane.add(c, 0, row0);
    		y5-=40.2;
        	if (row5>=0)
        	{
        		if(vendosNr(rendilojtarit))
        		{
        			array[row5][5]=2; //2 zi
        		}
        		else
        		{
        			array[row5][5]=1; // 1 kuq 
        		}
        		row5=row5-1;
        		if(row5<0)
        		{
        			buttonid5.setDisable(true);
        			buttonatdisable+=1;
        		}
        	}
    	}
    	else if(event.getSource()==buttonid6)
    	{
    		c=new Circle(16.5);
    		gpane.add(c, 6, 0);
    		
    		TranslateTransition transition=new TranslateTransition();
    		transition.setDuration(Duration.seconds(1));
    		transition.setToX(0);
    		transition.setToY(y6);
    		transition.setNode(c);
    		transition.play();
    		//transition.setPath(arrayRectangle.get(0));
    		mbushRrethin(rendilojtarit,c);
    		//gpane.add(c, 0, row0);
    		y6-=40.2;
        	if (row6>=0)
        	{
        		if(vendosNr(rendilojtarit))
        		{
        			array[row6][6]=2; //2 zi
        		}
        		else
        		{
        			array[row6][6]=1; // 1 kuq 
        		}
        		row6=row6-1;
        		if(row6<0)
        		{
        			buttonid6.setDisable(true);
        			buttonatdisable+=1;
        		}
        		shfaqArray();
        	}
    	}
    }
}
    public boolean diagonaleKryesore(int mat[][], int n)
    {
        
        int count=1;
        int [] arr=new int[6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
 
         
                if (i == j) {
                	
                    //System.out.print(mat[i][j] + ", ");
                    arr[i]=mat[i][j];
        			
                }
            }
        }

        
        for(int i=0;i<arr.length-1;i++)
        {
        	if(arr[i]==arr[i+1])
        	{
        		//System.out.print("I:"+arr[i]+ " I+1:"+arr[i+1] +" \n");
        		count++;
        	}
        	if(count>=4)
        	{
        		if(arr[i+1]==1)
        		{
        			cilifitoi=1;
        		}
        		else if(arr[i+1]==2)
        		{
        			cilifitoi=2;
        		}
        		return true;
        		
        	}
        	if(arr[i]!=arr[i+1])
        	{
        		count=1;
        		cilifitoi=3;
        	}
        	//System.out.println("COUNT:"+count);
        }
        return false;
        
    }
 
    public boolean diagonaljaDyte(int mat[][], int n)
    {
    	int count=1;
    	
        int [] arr=new int[6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
 
                // Condition for secondary diagonal
                if ((i + j) == (n - 1)) {
                   // System.out.print(mat[i][j] + ", ");
                    arr[i]=mat[i][j];
                }
            }
        }

        for(int i=0;i<arr.length-1;i++)
        {
        	if(arr[i]==arr[i+1])
        	{
        		//System.out.print("I:"+arr[i]+ " I+1:"+arr[i+1] +" \n");
        		count++;
        	}
        	if(count>=4)
        	{
        		if(arr[i+1]==1)
        		{
        			cilifitoi=1;
        		}
        		else if(arr[i+1]==2)
        		{
        			cilifitoi=2;
        		}
        		return true;
        		
        	}
        	if(arr[i]!=arr[i+1])
        	{
        		count=1;
        		cilifitoi=3;
        	}
        	//System.out.println("COUNT:"+count);
        }
        return false;
    }
    

    public boolean kontrolloFituesin(int[][] array) {// array rreshti length-1
    	if(kontrolloRreshtat(array,0,6) || kontrolloRreshtat(array,1,6) || kontrolloRreshtat(array,2,6)
    		|| kontrolloRreshtat(array,3,6) || kontrolloRreshtat(array,4,6) || kontrolloRreshtat(array,5,6) )
    		{
    			return true;
    		}
    			//array,
    		else if(kontrolloKolonat(array,0,5) || kontrolloKolonat(array,1,5) || kontrolloKolonat(array,2,5) 
    		|| kontrolloKolonat(array,3,5) || kontrolloKolonat(array,4,5))
    		{
    			return true;
    		}
    		else if(diagonaleKryesore(array, 6) || diagonaljaDyte(array, 6))
    		{
    			return true;
    		}
		return false;
    }
    public boolean kontrolloRreshtat(int[][] array,int rreshti,int length) {
		int count = 1; 
		for (int j = 0; j < length; j++) {
			if (array[rreshti][j]==array[rreshti][j+1]) 
				count++;
			
			if (count >= 4)
			{
				//txtid.setText(Integer.toString(array[rreshti][j]));
				if(array[rreshti][j+1]==1)
				{
					cilifitoi=1;
				}
				else if(array[rreshti][j+1]==2)
				{
					cilifitoi=2;
				}
				return true;
			}
			if (array[rreshti][j]!=array[rreshti][j+1])
				count = 1;
				cilifitoi=3;
		}
		return false;
	}
	public boolean kontrolloKolonat(int[][] array,int kolona,int length) {
		//System.out.print(array[0][0] +" "+array[1][0] +" "+array[2][0] +" "+array[3][0] +" ");
		int count = 1; 
		for (int j = 0; j < length; j++) {
			if (array[j][kolona]==array[j+1][kolona]) 
				count++;
			
			if (count >= 4)
			{
				//String s1=Integer.toString(array[j][kolona]);
				//txtid.setText(s1);
				if(array[j+1][kolona]==1)
				{
					cilifitoi=1;
				}
				else if(array[j+1][kolona]==2)
				{
					cilifitoi=2;
				}
				return true;
			}
			if (array[j][kolona]!=array[j+1][kolona])
				count = 1;
				cilifitoi=3;
		}
		return false;
	}


    public void mbushRrethin(int rendi,Circle circle)
    {
    	if(rendi%2==0)
    	{
    		circle.setFill(Color.RED);
    	}
    	else
    	{
    		circle.setFill(Color.BLACK);
    	}
    	rendilojtarit=rendi+1;
    }
    public boolean vendosNr(int rendi)
    {
    	if (rendi%2==0)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
 

    public void shfaqArray()
    {
    	txtid.setText("");
    	for(int i=0;i<6;i++)
		{
			for(int j=0;j<7;j++)
			{
				txtid.setText(txtid.getText()+ array[i][j] +" ");
			}
			txtid.setText(txtid.getText()+"\n");
		}
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		shfaqArray();
		
		for (i = 0; i < 6; i++) {
			
			for (j=0; j < 7; j++) {
				
				r = new Rectangle(35, 35,35,35);
				r.setStyle("-fx-fill: white; -fx-stroke: blue; -fx-stroke-width: 2;");
				gpane.add(r, j, i);
			}
		
			
		}
		
		
		
		
	}

}
