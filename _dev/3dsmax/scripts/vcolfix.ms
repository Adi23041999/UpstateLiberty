macroScript vColBorderFixMenu
	category:"GTA"
	buttonText: "Vertex Color Border Fix"
	toolTip:"Vertex Color Border Fix"
(
	fn findVertexPaint Obj = 
	(
		-- get or add a VertexPaint modifier
		if (classOf Obj.modifiers[1]) == VertexPaint then
		(
			v = Obj.modifiers[1]
		)
		else
		(
			v  = PaintLayerMod()
			addModifier Obj v
		)
		
		-- copy over existing vertex color into the modifier
		s = v.AcquirePaintState Obj
		v.MergeVertexColors Obj
		return v
	)
	
	fn vcolBorderFix =
	(
		selectedObjs = getCurrentSelection()
		convertToMesh selectedObjs

		for currentObj in selectedObjs do
		(
			-- find/add VertexPaint mod
			currentV = findVertexPaint currentObj
			currentS = currentV.AcquirePaintState currentObj
			
			-- loop selected vertices
			currentVerts = currentObj.selectedVerts
			for i=1 to currentVerts.count do
			(
				-- find position and color
				currentPos = currentVerts[i].pos as Point3
				currentVcol = currentS.getVertAverageColor currentVerts[i].index
				
				-- check every other object
				for checkedObj in selectedObjs do
				(
					if (checkedObj != currentObj) do
					(
						checkedVerts = checkedObj.selectedVerts
						
						-- loop selected vertices in the other objects
						for j=1 to checkedVerts.count do
						(
							checkedPos = checkedVerts[j].pos
							dist = distance currentPos checkedPos
							
							-- find the vertex of the checked object at the position of the current object's vertex position
							if distance currentPos checkedPos <= 0.1 do
							(
								-- find/add VertexPaint mod and vertex color
								checkedV = findVertexPaint checkedObj
								checkedS = checkedV.AcquirePaintState checkedObj
								
								checkedVcol = checkedS.getVertAverageColor checkedVerts[j].index

								-- new color - average of the two overlapping ones
								newColor = (currentVcol + checkedVcol) / 2.0

								-- apply the color on the current and checked vertices
								currentS.setVertColor currentVerts[i].index newColor
								checkedS.setVertColor checkedVerts[j].index newColor
								
								currentV.ApplyPaintState currentObj currentS
								checkedV.ApplyPaintState checkedObj checkedS
								break
							)
						)
					)
				)
			)
		)

		convertToPoly selectedObjs
	)
	
	vcolBorderFix()
)