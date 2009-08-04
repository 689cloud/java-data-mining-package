/*
 * Copyright (C) 2008-2009 Holger Arndt, A. Naegele and M. Bundschus
 *
 * This file is part of the Java Data Mining Package (JDMP).
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership and licensing.
 *
 * JDMP is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * JDMP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with JDMP; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin St, Fifth Floor,
 * Boston, MA  02110-1301  USA
 */

package org.jdmp.core.algorithm.index;

import java.util.List;

import org.jdmp.core.dataset.DataSet;
import org.jdmp.core.sample.Sample;
import org.ujmp.core.Matrix;

public interface Index {

	public static final String INPUT = "Input";

	public static final String SCORE = "Score";

	public void add(Matrix input) throws Exception;

	public void add(Sample sample) throws Exception;

	public void add(DataSet dataSet) throws Exception;

	public DataSet search(String query, int start, int count) throws Exception;

	public DataSet search(String query) throws Exception;

	public DataSet search(String query, int count) throws Exception;

	public DataSet searchSimilar(Sample sample, int start, int count) throws Exception;

	public DataSet searchSimilar(Sample sample) throws Exception;

	public DataSet searchSimilar(Sample sample, int count) throws Exception;

	public int getSize() throws Exception;

	public Sample getSample(String id) throws Exception;

	public List<String> getSuggestions(String word, int count) throws Exception;

}