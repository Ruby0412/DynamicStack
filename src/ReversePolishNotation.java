import java.util.Scanner;
import java.math.BigInteger;

public class ReversePolishNotation {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		RedBlackTree rbt = new RedBlackTree();
		DynamicStack op = new DynamicStack();
		BigInteger zero = new BigInteger("0");
		Scanner keyboard = new Scanner(System.in);
		boolean run = true;
		BigInteger ans = null;
		while(run) {
		String str = keyboard.nextLine();
		if(str.equals("")) {
			run = false;
			System.out.println("terminating");
			break;
		}
		String[] in = str.split(" ");
		for (int i = 0; i < in.length; i ++) {
			if(in[i].matches("^[0-9]+$") ||in[i].matches("^[a-zA-Z]+$")) {
					op.push(in[i]);
			}
			else {
				switch(in[i]) {
				case "~": {
					
					BigInteger firstNum = null;
					if(op.isEmpty()) {
						throw new Exception("error: stack underflow exception");
					}
					String a = op.pop()+"";
					
					if(rbt.contains(a)) {
						firstNum = rbt.lookup((a));
					}
					else { 
						try {
						firstNum = new BigInteger(a);
						}catch(Exception ex) {
							throw new Exception("error: no variable "+a);
						}
					}
	                ans = zero.subtract(firstNum);
	                op.push(ans);
	                
	                break;
					}
				case "-": {
					BigInteger SecondNum = null;
					BigInteger firstNum = null;
					if(op.isEmpty()) {
						throw new Exception("error: stack underflow exception");
					}
					String a = op.pop()+"";
					if(rbt.contains(a)) {
						SecondNum = rbt.lookup((a));
					}
					else {
						try {
						SecondNum = new BigInteger(a);
						}catch(Exception ex) {
							throw new Exception("error: no variable "+a);
						}
					
					}
					if(op.isEmpty()) {
						throw new Exception("error: stack underflow exception");
					}
					String b = op.pop()+"";
					if(rbt.contains(b)) {
						firstNum = rbt.lookup((b));
					}
					else {
						try {
						firstNum = new BigInteger(b);
						}catch(Exception ex) {
							throw new Exception("error: no variable "+b);
						}
					}
	                ans = firstNum.subtract(SecondNum);
	                op.push(ans);
	                break;
					}
				case "+": {
					BigInteger SecondNum = null;
					BigInteger firstNum = null;
					if(op.isEmpty()) {
						throw new Exception("error: stack underflow exception");
					}
					String a = op.pop()+"";
					if(rbt.contains(a)) {
						SecondNum = rbt.lookup((a));
					}
					else {
						try {
						SecondNum = new BigInteger(a);
						}catch(Exception ex) {
							throw new Exception("error: no variable "+a);
						}
					
					}
					if(op.isEmpty()) {
						throw new Exception("error: stack underflow exception");
					}
					String b = op.pop()+"";
					if(rbt.contains(b)) {
						firstNum = rbt.lookup((b));
					}
					else {
						try {
						firstNum = new BigInteger(b);
						}catch(Exception ex) {
							throw new Exception("error: no variable "+b);
						}
					}
	                ans = firstNum.add(SecondNum);
	                op.push(ans);
	                break;
					}
				case "%": {
					BigInteger SecondNum = null;
					BigInteger firstNum = null;
					if(op.isEmpty()) {
						throw new Exception("error: stack underflow exception");
					}
					String a = op.pop()+"";
					if(rbt.contains(a)) {
						SecondNum = rbt.lookup((a));
					}
					else {
						try {
						SecondNum = new BigInteger(a);
						}catch(Exception ex) {
							throw new Exception("error: no variable "+a);
						}
					
					}
					if(op.isEmpty()) {
						throw new Exception("error: stack underflow exception");
					}
					String b = op.pop()+"";
					if(rbt.contains(b)) {
						firstNum = rbt.lookup((b));
					}
					else {
						try {
						firstNum = new BigInteger(b);
						}catch(Exception ex) {
							throw new Exception("error: no variable "+b);
						}
					}
	                ans = firstNum.mod(SecondNum);
	                op.push(ans);
	                break;
					}
				case "/": {
					BigInteger SecondNum = null;
					BigInteger firstNum = null;
					if(op.isEmpty()) {
						throw new Exception("error: stack underflow exception");
					}
					String a = op.pop()+"";
					if(rbt.contains(a)) {
						SecondNum = rbt.lookup((a));
					}
					else {
						try {
						SecondNum = new BigInteger(a);
						}catch(Exception ex) {
							throw new Exception("error: no variable "+a);
						}
					
					}
					if(op.isEmpty()) {
						throw new Exception("error: stack underflow exception");
					}
					String b = op.pop()+"";
					if(rbt.contains(b)) {
						firstNum = rbt.lookup((b));
					}
					else {
						try {
						firstNum = new BigInteger(b);
						}catch(Exception ex) {
							throw new Exception("error: no variable "+b);
						}
					}
	                ans = firstNum.divide(SecondNum);
	                op.push(ans);
	                break;
					}
				case "*": {
					BigInteger SecondNum = null;
					BigInteger firstNum = null;
					if(op.isEmpty()) {
						throw new Exception("error: stack underflow exception");
					}
					String a = op.pop()+"";
					if(rbt.contains(a)) {
						SecondNum = rbt.lookup((a));
					}
					else {
						try {
						SecondNum = new BigInteger(a);
						}catch(Exception ex) {
							throw new Exception("error: no variable "+a);
						}
					
					}
					if(op.isEmpty()) {
						throw new Exception("error: stack underflow exception");
					}
					String b = op.pop()+"";
					if(rbt.contains(b)) {
						firstNum = rbt.lookup((b));
					}
					else {
						try {
						firstNum = new BigInteger(b);
						}catch(Exception ex) {
							throw new Exception("error: no variable "+b);
						}
					}
	                ans = firstNum.multiply(SecondNum);
	                op.push(ans);
	                break;
					}
				case "#": {
					BigInteger thirdNum = null;
					BigInteger SecondNum = null;
					BigInteger firstNum = null;
					if(op.isEmpty()) {
						throw new Exception("error: stack underflow exception");
					}
					String c = op.pop()+"";
					if(rbt.contains(c)) {
						thirdNum = rbt.lookup((c));
					}
					else {
						try {
						thirdNum = new BigInteger(c);
						}catch(Exception ex) {
							throw new Exception("stack underflow exception");
						}
					}
					if(op.isEmpty()) {
						throw new Exception("error: stack underflow exception");
					}
					String a = op.pop()+"";
					if(rbt.contains(a)) {
						SecondNum = rbt.lookup((a));
					}
					else {
						try {
						SecondNum = new BigInteger(a);
						}catch(Exception ex) {
							throw new Exception("stack underflow exception");
						}
					
					}
					if(op.isEmpty()) {
						throw new Exception("error: stack underflow exception");
					}
					String b = op.pop()+"";
					if(rbt.contains(b)) {
						firstNum = rbt.lookup((b));
					}
					else {
						try {
						firstNum = new BigInteger(b);
						}catch(Exception ex) {
							throw new Exception("stack underflow exception");
						}
					}
					
					try {
	                ans = (firstNum .pow(SecondNum.intValue())).mod(thirdNum);
					}catch(Exception ex) {
						throw new Exception("calculation exception");
					}
	                op.push(ans);
					
					
	                break;
					}
				case"=":{
					if(op.isEmpty()) {
						throw new Exception("error: stack underflow exception");
					}
					BigInteger op2 =  new BigInteger(op.pop()+"");
					if(op.isEmpty()) {
						throw new Exception("error: stack underflow exception");
					}
	                String op1 =  (String) op.pop();
	                try {
	                if(op1.matches("^[0-9]+$")) {
						throw new Exception("");
					}
	                }catch(Exception ex) {
	                		throw new Exception("error: "+op1+" not an lvalue");
	                }
	                rbt.insert(op1, op2);
	                op.push(op2);
	                break;
				}
//				default: {
//					System.out.print("");
//					BigInteger firstNum = rbt.lookup(in[i]);
//					if(rbt.contains(in[i])) {
//						op.push(in[i]);
//						String SecondNum = (String) op.pop();
//						op.push(firstNum);
//						break;
//					}
//					else {
//						op.push(in[i]);
//							}
//						}
					} 
				}
			
		    }	
		
		String result = op.pop() + "";
		if(rbt.contains(result)) {
			System.out.println(rbt.lookup(result));
		}
		else {
			System.out.println(result);
			}
	}
	}
			
}