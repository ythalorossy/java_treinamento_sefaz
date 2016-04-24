/**
 * 
 */
package com.wordpress.yross.cdi.producers;

import java.util.Random;

import javax.enterprise.inject.Produces;

import com.wordpress.yross.cdi.qualifiers.Randomico;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com - http://yross.wordpress.com)
 */
public class AppProducers {

	@Produces
	@Randomico
	public int numeroRandomico() {
		Random random = new Random(System.currentTimeMillis());
		return random.nextInt(1000000); 
	}
}
