package FixEXpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ��׺���ʽתǰ׺���ʽ
 * @author ����
 *
 */
public class InfixToPrefix {

	public static List<Token> convert(String expr)
	{
		List<Token> inFixTokens=new TokenParser().parse(expr);
		//�Ƚ�ÿһ��token�ŵ�һ��ջ��
		Stack<Token> inFix=new Stack<>();
		for(Token token:inFixTokens)
		{
			inFix.push(token);
		}
		List<Token> preFixTokens=new ArrayList<>();
		Stack<Token> preFix=new Stack<>();
		Stack<Token> opStack=new Stack<>();
		while(!inFix.isEmpty())
		{
			Token token=inFix.pop();
			if(token.isNumber())
			{
				preFix.push(token);
			}
			else{
				while(!opStack.isEmpty()&&!token.hasHigherPriority(opStack.peek()))
				{
					preFix.push(opStack.pop());
				}
				opStack.push(token);
			}
		}
		while(!opStack.isEmpty())
		{
			preFix.push(opStack.pop());
		}
		while(!preFix.isEmpty())
		{
			preFixTokens.add(preFix.pop());
		}
		return preFixTokens;
	}
}
